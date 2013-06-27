package com.robin;

import java.util.Set;

import com.robin.pieces.Piece;
import com.robin.position.Position;

public interface Strategy {
    Position calculatePositionToPlace(Piece piece, int boardSize, Set<Position> availablePositions, Set<Position> occupiedPositions);
}
