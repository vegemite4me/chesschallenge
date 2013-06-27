package com.robin.pieces;

import java.util.Set;

import com.robin.position.Position;
import com.robin.position.PositionUtils;

public class Rook extends Piece {
    @Override
    public Set<Position> getAttackablePositions(int boardSize, Position position) {
        return PositionUtils.getPositionsInStraightLines(position, boardSize);
    }

    @Override
    public String toChar() {
        return "R";
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
