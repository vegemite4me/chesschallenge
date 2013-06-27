package com.robin.pieces;

import java.util.Set;

import com.robin.position.Position;

import static com.robin.position.PositionUtils.getPositionsInDiagonalLines;

public class Bishop extends Piece {

    @Override
    public Set<Position> getAttackablePositions(int boardSize, Position position) {
        return getPositionsInDiagonalLines(position, boardSize);
    }

    @Override
    public String toChar() {
        return "B";
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}
