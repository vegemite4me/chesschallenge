package com.robin.pieces;

import java.util.Set;

import org.junit.Test;

import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RookTest {

    @Test
    public void testGetAttackablePositionsFromCorner() throws Exception {
        // Given
        Rook rook = new Rook();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = rook.getAttackablePositions(boardSize, Position.valueOf(0, 0));

        // Then
        // Across
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 3)));
        // Down
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));

        assertThat(attackablePositions.size(), is(6));
    }

    @Test
    public void testGetAttackablePositionsFromInner() throws Exception {
        // Given
        Rook rook = new Rook();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = rook.getAttackablePositions(boardSize, Position.valueOf(1, 2));

        // Then
        // Across
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 3)));
        // Down
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 2)));

        assertThat(attackablePositions.size(), is(6));
    }
}
