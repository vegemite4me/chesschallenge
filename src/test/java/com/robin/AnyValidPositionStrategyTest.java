package com.robin;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.robin.pieces.King;
import com.robin.position.Position;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class AnyValidPositionStrategyTest {

    private AnyValidPositionStrategy anyValidPositionStrategy;

    @Before
    public void setUp() {
        anyValidPositionStrategy = new AnyValidPositionStrategy();
    }

    @Test
    public void shouldCalculateAValidPositionWhenGivenAnEmptyBoard() throws Exception {
        // Given
        King king = new King();
        int boardSize = 4;
        Set<Position> availablePositions = BoardFactory.generatePositions(boardSize);
        HashSet<Position> taken = new HashSet<Position>();

        // When
        Position position = anyValidPositionStrategy.calculatePositionToPlace(king, boardSize, availablePositions, taken);

        // Then
        assertThat(position, is(Position.valueOf(0, 0)));
        System.out.println(position);
    }

    @Test
    public void shouldCalculateAValidPositionWhenGivenABoardWithOneTakenPosition() throws Exception {
        // Given
        King king = new King();
        int boardSize = 4;
        Set<Position> availablePositions = BoardFactory.generatePositions(boardSize);
        availablePositions.remove(Position.valueOf(0, 0));

        HashSet<Position> taken = new HashSet<Position>();
        taken.add(Position.valueOf(0, 0));

        // When
        Position position = anyValidPositionStrategy.calculatePositionToPlace(king, boardSize, availablePositions, taken);

        // Then
        System.out.println(position);
        assertThat(position, not(Position.valueOf(0, 0)));
        assertThat(position, not(Position.valueOf(1, 0)));
        assertThat(position, not(Position.valueOf(1, 1)));
        assertThat(position, not(Position.valueOf(0, 1)));
    }

}
