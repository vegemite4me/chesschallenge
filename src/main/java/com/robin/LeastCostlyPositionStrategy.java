package com.robin;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.robin.pieces.Piece;
import com.robin.position.Position;

import static com.robin.util.CollectionUtils.containsAnyMatching;

public class LeastCostlyPositionStrategy implements Strategy {

    @Override
    public Position calculatePositionToPlace(Piece piece, int boardSize, Set<Position> availablePositions, Set<Position> occupiedPositions) {

        Position leastCostlyPosition = null;
        int lowestCost = Integer.MAX_VALUE;
        Set<Position> a = Collections.unmodifiableSet(availablePositions);
        for (Position emptyPosition : a) {

            int cost = calculateCostOfPuttingPieceAtPosition(piece, emptyPosition, boardSize, a, occupiedPositions);
//            System.out.println("Putting " + piece + " at " + emptyPosition + " will result in " + cost + " less available positions.");
            if (cost < lowestCost) {
//                System.out.println("That's better than before.");
                lowestCost = cost;
                leastCostlyPosition = emptyPosition;
            }
        }
        return leastCostlyPosition;
    }

//    public boolean isPieceValidAtPosition(Piece piece, Position position, int boardSize, Set<Position> occupiedPositions) {
//        Set<Position> attackablePositions = piece.getAttackablePositions(boardSize, position);
//        return isValidPosition(occupiedPositions, attackablePositions);
//    }

    private int calculateCostOfPuttingPieceAtPosition(Piece piece, Position position, int boardSize, Set<Position> availablePositions, Set<Position> occupiedPositions) {
        Set<Position> attackablePositions = piece.getAttackablePositions(boardSize, position);
        if (isValidPosition(occupiedPositions, attackablePositions)) {
            Set<Position> s = new HashSet<Position>(availablePositions);
            s.remove(position);
            s.removeAll(attackablePositions);
//            return s.size();
            return availablePositions.size() - s.size();
        }
        return Integer.MAX_VALUE;
    }

    private boolean isValidPosition(Set<Position> occupiedPositions, Set<Position> attackablePositions) {
        return !containsAnyMatching(attackablePositions, occupiedPositions);
    }

}
