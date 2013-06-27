package com.robin.pieces;

import java.util.Set;

import org.junit.Test;

import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KnightTest {

    @Test
    public void testGetAttackablePositionsFromCorner() throws Exception {
        // Given
        Knight knight = new Knight();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = knight.getAttackablePositions(boardSize, Position.valueOf(0, 0));

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 2)));
        assertThat(attackablePositions.size(), is(2));
    }

    @Test
    public void testGetAttackablePositionsFromInner() throws Exception {
        // Given
        Knight knight = new Knight();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = knight.getAttackablePositions(boardSize, Position.valueOf(1, 2));

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 3)));

        assertThat(attackablePositions.size(), is(4));
    }

    @Test
    public void testGetAttackablePositionsFromMoreInner() throws Exception {
        // Given
        Knight knight = new Knight();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = knight.getAttackablePositions(boardSize, Position.valueOf(2, 2));

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 3)));

        assertThat(attackablePositions.size(), is(4));
    }
}
