package com.robin.pieces;

import java.util.HashSet;
import java.util.Set;

import com.robin.position.Position;
import com.robin.position.PositionUtils;

import static com.robin.position.PositionUtils.getPositionsInDiagonalLines;
import static com.robin.position.PositionUtils.getPositionsInStraightLines;

public class Queen extends Piece {

    @Override
    public Set<Position> getAttackablePositions(int boardSize, Position position) {

        Set<Position> positionsInStraightLines = getPositionsInStraightLines(position, boardSize);
        Set<Position> positionsInDiagonalLines = getPositionsInDiagonalLines(position, boardSize);

        Set<Position> positions = new HashSet<Position>();
        positions.addAll(positionsInStraightLines);
        positions.addAll(positionsInDiagonalLines);

        return positions;
    }

    @Override
    public String toChar() {
        return "Q";
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
