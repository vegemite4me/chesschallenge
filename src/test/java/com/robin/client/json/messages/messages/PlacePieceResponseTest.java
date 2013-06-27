package com.robin.client.json.messages.messages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robin.client.json.messages.PlacedPiece;
import com.robin.client.json.messages.Response;
import com.robin.client.json.messages.util.PieceJsonDeserializer;
import com.robin.pieces.King;
import com.robin.pieces.Piece;
import com.robin.pieces.Queen;
import com.robin.pieces.Rook;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlacePieceResponseTest {

    @Test
    public void testSimple() throws FileNotFoundException {
        // Given
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Piece.class, new PieceJsonDeserializer());
        final Gson gson = gsonBuilder.create();

        URL resource = PlacePieceResponseTest.class.getClassLoader().getResource("PlacePieceResponse.json");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        // When
        Response response = gson.fromJson(br, Response.class);

        // Then
        assertThat(response.getGameId(), is("922d6f19-dbe9-428e-ac10-16d297e0290c"));
        assertThat(response.getCurrentPiece(), instanceOf(King.class));
        assertThat(response.getNextPiece(), instanceOf(Rook.class));
        assertThat(response.getPlacedPieces().size(), is(1));
        assertThat(response.getPlacedPieces().get(0).getPiece(), instanceOf(Queen.class));
        assertThat(response.getPlacedPieces().get(0).getRow(), is(1));
        assertThat(response.getPlacedPieces().get(0).getColumn(), is(2));
        assertThat(response.getScore(), is(1));
        assertThat(response.getMessage(), is("Running"));
        assertThat(response.isLive(), is(true));
        assertThat(response.getSize(), is(5));
        assertThat(response.getMillisecondsLeft(), is(654L));
        System.out.println(response);
    }
}
