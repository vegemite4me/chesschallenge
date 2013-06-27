package com.robin.position;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.Collections.unmodifiableSet;

public class PositionUtils {

    private static final ConcurrentMap<Position, Set<Position>> straightLinesFromPosition = new ConcurrentHashMap<Position, Set<Position>>();
    private static final ConcurrentMap<Position, Set<Position>> diagonalLinesFromPosition = new ConcurrentHashMap<Position, Set<Position>>();
    private static final ConcurrentMap<Position, Set<Position>> surroundingsFromPosition = new ConcurrentHashMap<Position, Set<Position>>();
    private static final ConcurrentMap<Position, Set<Position>> knightMovesFromPosition = new ConcurrentHashMap<Position, Set<Position>>();
    private static final int MAX_KNIGHT_MOVES = 8;

    public static Set<Position> getPositionsInStraightLines(Position from, int boardSize) {
        Set<Position> positions = straightLinesFromPosition.get(from);
        if (positions == null) {
            positions = positionsInStraightLines(from, boardSize);
            Set<Position> existingPositions = straightLinesFromPosition.putIfAbsent(from, unmodifiableSet(positions));
            if (existingPositions != null) {
                positions = existingPositions;
            }
        }
        return positions;
    }

    public static Set<Position> getPositionsInDiagonalLines(Position from, int boardSize) {
        Set<Position> positions = diagonalLinesFromPosition.get(from);
        if (positions == null) {
            positions = positionsInDiagonalLines(from, boardSize);
            Set<Position> existingPositions = diagonalLinesFromPosition.putIfAbsent(from, unmodifiableSet(positions));
            if (existingPositions != null) {
                positions = existingPositions;
            }
        }
        return positions;
    }

    public static Set<Position> getPositionsSurrounding(Position from, int boardSize) {
        Set<Position> positions = surroundingsFromPosition.get(from);
        if (positions == null) {
            positions = surroundingPositions(from, boardSize);
            Set<Position> existingPositions = surroundingsFromPosition.putIfAbsent(from, unmodifiableSet(positions));
            if (existingPositions != null) {
                positions = existingPositions;
            }
        }
        return positions;
    }

    public static Set<Position> getKnightMovesFrom(Position from, int boardSize) {
        Set<Position> positions = knightMovesFromPosition.get(from);
        if (positions == null) {
            positions = knightMovesFrom(from, boardSize);
            Set<Position> existingPositions = knightMovesFromPosition.putIfAbsent(from, unmodifiableSet(positions));
            if (existingPositions != null) {
                positions = existingPositions;
            }
        }
        return positions;
    }

    private static Set<Position> positionsInStraightLines(Position from, int boardSize) {
        Set<Position> positions = new HashSet<Position>();
        for (int x = 0; x < boardSize; x++) {
            if (x != from.getX()) {
                positions.add(Position.valueOf(x, from.getY()));
            }
        }
        for (int y = 0; y < boardSize; y++) {
            if (y != from.getY()) {
                positions.add(Position.valueOf(from.getX(), y));
            }
        }
        return positions;
    }

    private static Set<Position> positionsInDiagonalLines(Position from, int boardSize) {
        Set<Position> positions = new HashSet<Position>();
        int x = from.getX();
        int y = from.getY();
        while(++x < boardSize && ++y < boardSize) {
            positions.add(Position.valueOf(x, y));
        }
        // down left
        x = from.getX();
        y = from.getY();
        while(--x >= 0 && ++y < boardSize) {
            positions.add(Position.valueOf(x, y));
        }
        // up left
        x = from.getX();
        y = from.getY();
        while(--x >= 0 && --y >= 0) {
            positions.add(Position.valueOf(x, y));
        }
        // up right
        x = from.getX();
        y = from.getY();
        while(++x < boardSize && --y >= 0) {
            positions.add(Position.valueOf(x, y));
        }
        return positions;
    }

    private static Set<Position> surroundingPositions(Position from, int boardSize) {
        Set<Position> positions = new HashSet<Position>();
        if (from.getX() > 0) {
            positions.add(from.left());
        }
        if (from.getY() > 0) {
            positions.add(from.up());
        }
        if (from.getX() < boardSize-1) {
            positions.add(from.right());
        }
        if (from.getY() < boardSize-1) {
            positions.add(from.down());
        }

        if (from.getX() > 0 && from.getY() > 0) {
            positions.add(from.upLeft());
        }
        if (from.getX() < boardSize-1 && from.getY() < boardSize-1) {
            positions.add(from.downRight());
        }
        if (from.getX() < boardSize-1 && from.getY() > 0) {
            positions.add(from.upRight());
        }
        if (from.getX() > 0 && from.getY() < boardSize-1) {
            positions.add(from.downLeft());
        }
        return positions;
    }

    private static Set<Position> knightMovesFrom(Position from, int boardSize) {
        Set<Position> positions = new HashSet<Position>();

        int[] xs = new int[MAX_KNIGHT_MOVES];
        int[] ys = new int[MAX_KNIGHT_MOVES];

        xs[0] = from.getX()-2;
        xs[1] = from.getX()-1;
        xs[2] = from.getX()+1;
        xs[3] = from.getX()+2;
        xs[4] = from.getX()+2;
        xs[5] = from.getX()+1;
        xs[6] = from.getX()-1;
        xs[7] = from.getX()-2;

        ys[0] = from.getY()-1;
        ys[1] = from.getY()-2;
        ys[2] = from.getY()-2;
        ys[3] = from.getY()-1;
        ys[4] = from.getY()+1;
        ys[5] = from.getY()+2;
        ys[6] = from.getY()+2;
        ys[7] = from.getY()+1;

        for (int i = 0; i < MAX_KNIGHT_MOVES; i++) {
            if (isValidPosition(xs[i], ys[i], boardSize)) {
                positions.add(Position.valueOf(xs[i], ys[i]));
            }
        }

        return positions;
    }

    private static boolean isValidPosition(int x, int y, int boardSize) {
        return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
    }


}
