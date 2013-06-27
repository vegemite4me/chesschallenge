package com.robin.pieces;

import java.util.HashSet;
import java.util.Set;

import com.robin.position.Position;
import com.robin.position.PositionUtils;

public class King extends Piece {

    @Override
    public Set<Position> getAttackablePositions(int boardSize, Position position) {
        return PositionUtils.getPositionsSurrounding(position, boardSize);
    }

    @Override
    public String toChar() {
        return "K";
    }

    @Override
    public String toString() {
        return "King";
    }

}
