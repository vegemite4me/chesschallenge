package com.robin;

import java.util.Set;

import com.robin.pieces.Piece;
import com.robin.position.Position;

import static com.robin.util.CollectionUtils.containsAnyMatching;

public class AnyValidPositionStrategy implements Strategy {

    @Override
    public Position calculatePositionToPlace(Piece piece, int boardSize, Set<Position> availablePositions, Set<Position> occupiedPositions) {
        for (Position emptyPosition : availablePositions) {
            if (isPieceValidAtPosition(piece, emptyPosition, boardSize, occupiedPositions)) {
                return emptyPosition;
            }
        }
        return null;
    }

    public boolean isPieceValidAtPosition(Piece piece, Position position, int boardSize, Set<Position> takenPositions) {
        Set<Position> attackablePositions = piece.getAttackablePositions(boardSize, position);
        return !containsAnyMatching(attackablePositions, takenPositions);
    }

}
