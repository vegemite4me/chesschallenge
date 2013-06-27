package com.robin.client;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.robin.pieces.Piece;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;

@Ignore
public class JsonClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testStartGameAndGetFirstPiece() throws Exception {
        // Given
        String endPoint = "http://localhost:8080";
        JsonClient jsonClient = new JsonClient(endPoint);

        // When
        Piece firstPiece = jsonClient.startGameAndGetFirstPiece(4);

        // Then
        assertThat(firstPiece, notNullValue());
        System.out.println(firstPiece);
    }

    @Test
    public void testGetNextPiece() throws Exception {

    }
}
