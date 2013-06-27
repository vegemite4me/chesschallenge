package com.robin.client.json.messages.messages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robin.client.json.messages.Response;
import com.robin.client.json.messages.util.PieceJsonDeserializer;
import com.robin.pieces.King;
import com.robin.pieces.Piece;
import com.robin.pieces.Queen;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NewGameResponseTest {

    @Test
    public void testSimple() throws FileNotFoundException {
        // Given
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Piece.class, new PieceJsonDeserializer());
        final Gson gson = gsonBuilder.create();

        URL resource = NewGameResponseTest.class.getClassLoader().getResource("NewGameResponse.json");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        // When
        Response response = gson.fromJson(br, Response.class);

        // Then
        assertThat(response.getLinks().size(), is(3));
        assertThat(response.getLinks().get(1).getRel(), is("PlacePiece"));
        assertThat(response.getLinks().get(1).getHRef(), is("/PlacePiece/922d6f19-dbe9-428e-ac10-16d297e0290c/<row>/<column>"));
        assertThat(response.getLinks().get(1).getMethod(), is("POST"));
        assertThat(response.getLinks().size(), is(3));
        assertThat(response.getGameId(), is("922d6f19-dbe9-428e-ac10-16d297e0290c"));
        assertThat(response.getCurrentPiece(), instanceOf(Queen.class));
        assertThat(response.getNextPiece(), instanceOf(King.class));
        assertThat(response.getScore(), is(123));
        assertThat(response.getMessage(), is("Running"));
        assertThat(response.isLive(), is(true));
        assertThat(response.getSize(), is(4));
        assertThat(response.getMillisecondsLeft(), is(99L));
        System.out.println(response);
    }
}
