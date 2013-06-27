package com.robin.pieces;

import java.util.Set;

import org.junit.Test;

import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueenTest {

    @Test
    public void testGetAttackablePositionsFromCorner() throws Exception {
        // Given
        Queen queen = new Queen();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = queen.getAttackablePositions(boardSize, Position.valueOf(0, 0));

        // Then
        // Across
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 3)));
        // Down
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));
        // Diaginal
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 3)));

        assertThat(attackablePositions.size(), is(9));
    }

    @Test
    public void testGetAttackablePositionsFromInner() throws Exception {
        // Given
        Queen queen = new Queen();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = queen.getAttackablePositions(boardSize, Position.valueOf(1, 2));

        // Then
        // Across
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 3)));
        // Down
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 2)));
        // Diaginal
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 3)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 3)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));

        assertThat(attackablePositions.size(), is(11));
    }
}
