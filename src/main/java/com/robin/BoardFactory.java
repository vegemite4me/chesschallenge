package com.robin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.robin.pieces.Piece;
import com.robin.position.Position;

public class BoardFactory {

    public static Board createBoard(int size) {

        Map<Position, Piece> initialState = new HashMap<Position, Piece>();

//        for (Position position : generatePositions(size)) {
//            initialState.put(position, null);
//        }

        return new Board(size, initialState);
    }

    public static Set<Position> generatePositions(int boardSize) {
        Set<Position> positions = new HashSet<Position>(boardSize);
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                positions.add(Position.valueOf(x, y));
            }
        }
        return positions;
    }
}
