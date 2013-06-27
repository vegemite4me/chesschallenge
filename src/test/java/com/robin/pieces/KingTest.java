package com.robin.pieces;

import java.util.Set;

import org.junit.Test;

import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KingTest {

    @Test
    public void testGetAttackablePositionsFromCorner() throws Exception {
        // Given
        King king = new King();
        Position position = new Position(0, 0);

        // When
        Set<Position> attackablePositions = king.getAttackablePositions(4, position);

        // Then
        assertThat(attackablePositions, hasItems(Position.valueOf(1, 0),
                                                 Position.valueOf(0, 1),
                                                 Position.valueOf(1, 1)));
        assertThat(attackablePositions.size(), is(3));
    }

    @Test
    public void testGetAttackablePositionsFromMiddle() throws Exception {
        // Given
        King king = new King();
        Position position = Position.valueOf(1, 1);

        // When
        Set<Position> attackablePositions = king.getAttackablePositions(4, position);

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 2)));
        assertThat(attackablePositions.size(), is(8));
    }

    @Test
    public void testGetAttackablePositionsFromEdge() throws Exception {
        // Given
        King king = new King();
        Position position = Position.valueOf(3, 1);

        // When
        Set<Position> attackablePositions = king.getAttackablePositions(4, position);

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 2)));
        assertThat(attackablePositions.size(), is(5));
    }
}
