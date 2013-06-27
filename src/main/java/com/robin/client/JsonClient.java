package com.robin.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robin.client.json.messages.Response;
import com.robin.client.json.messages.util.PieceJsonDeserializer;
import com.robin.pieces.Piece;
import com.robin.position.Position;

public class JsonClient implements Client {

    private final String endPoint;
    private volatile String gameId;
    private Gson gson;

    public JsonClient(String endPoint) {
        this.endPoint = endPoint;

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Piece.class, new PieceJsonDeserializer());
        gson = gsonBuilder.create();
    }

    @Override
    public Piece startGameAndGetFirstPiece(int boardSize) {
        HttpGet request = new HttpGet(endPoint + "/NewGame/" + boardSize);
        Response response = makeCallAndGetResponse(request);
        gameId = response.getGameId();
        return response.getCurrentPiece();
    }

    @Override
    public Piece startTournamentAndGetFirstPiece(String playerId) {
        HttpGet request = new HttpGet(endPoint + "/NewTournamentGame/" + playerId);
        Response response = makeCallAndGetResponse(request);
        gameId = response.getGameId();
        return response.getCurrentPiece();
    }

    @Override
    public Piece placeCurrentPiece(Position position) {
        String url = String.format("%s/PlacePiece/%s/%d/%d", endPoint, gameId, position.getX(), position.getY());
        HttpPost request = new HttpPost(url);
        Response response = makeCallAndGetResponse(request);
        return response.getCurrentPiece();
    }

    private Response makeCallAndGetResponse(HttpUriRequest request) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(request);
            InputStream input = httpResponse.getEntity().getContent();
            Response response = gson.fromJson(new InputStreamReader(input), Response.class);
            printResponse(response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printResponse(Response response) {
        System.out.println(response.getCurrentPiece() + " (" + response.getMessage() + ") " + response.getScore());
    }

}
