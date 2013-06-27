package com.robin;

import java.util.Map;

import org.junit.Test;

import com.robin.pieces.Piece;
import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardFactoryTest {

    @Test
    public void testCreate() throws Exception {
        // Given

        // When
        Board board = BoardFactory.createBoard(4);

        // Then
        Map<Position,Piece> currentState = board.getPlacedPieces();
        assertThat(currentState.keySet().size(), is(0));
    }
}
