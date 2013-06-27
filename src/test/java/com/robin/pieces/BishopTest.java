package com.robin.pieces;

import java.util.Set;

import org.junit.Test;

import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopTest {

    @Test
    public void testGetAttackablePositionsFromCorner() throws Exception {
        // Given
        Bishop bishop = new Bishop();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = bishop.getAttackablePositions(boardSize, Position.valueOf(0, 0));

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(1, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 2)));
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 3)));

        assertThat(attackablePositions.size(), is(3));
    }

    @Test
    public void testGetAttackablePositionsFromInner() throws Exception {
        // Given
        Bishop bishop = new Bishop();
        int boardSize = 4;

        // When
        Set<Position> attackablePositions = bishop.getAttackablePositions(boardSize, Position.valueOf(1, 2));

        // Then
        assertThat(attackablePositions, hasItem(Position.valueOf(3, 0)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 1)));
        assertThat(attackablePositions, hasItem(Position.valueOf(2, 3)));
        assertThat(attackablePositions, hasItem(Position.valueOf(0, 3)));

        assertThat(attackablePositions.size(), is(5));
    }
}
