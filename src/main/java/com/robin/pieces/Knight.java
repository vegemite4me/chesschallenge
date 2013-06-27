package com.robin.pieces;

import java.util.Set;

import com.robin.position.Position;
import com.robin.position.PositionUtils;

public class Knight extends Piece {

    @Override
    public Set<Position> getAttackablePositions(int boardSize, Position position) {
        return PositionUtils.getKnightMovesFrom(position, boardSize);
    }

    @Override
    public String toChar() {
        return "N";
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
