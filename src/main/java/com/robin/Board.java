package com.robin;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.robin.pieces.Piece;
import com.robin.position.Position;

public class Board {

    private static final String LEFT_POSITION = "+---+";
    private static final String POSITION = "---+";

    private final int size;
    private final Map<Position, Piece> placedPieces;
    private final Set<Position> availablePositions;
    private final Set<Position> takenPositions = new HashSet<Position>();

    Board(int size, Map<Position, Piece> placedPieces) {
        this.size = size;
        this.placedPieces = placedPieces;
        availablePositions = BoardFactory.generatePositions(size);
    }

    public void place(Position position, Piece piece) {
        synchronized (this) {
            if (placedPieces.containsKey(position)) {
                throw new IllegalArgumentException("The position " + position + " already contains " + placedPieces.get(position));
            }
            placedPieces.put(position, piece);

            availablePositions.remove(position);
            availablePositions.removeAll(piece.getAttackablePositions(size, position));

            takenPositions.add(position);
        }
    }

    public Map<Position, Piece> getPlacedPieces() {
        return Collections.unmodifiableMap(placedPieces);
    }

    public Set<Position> getAvailablePositions() {
            return Collections.unmodifiableSet(availablePositions);
    }

    public Set<Position> getTakenPositions() {
            return Collections.unmodifiableSet(takenPositions);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(spacerLine());

        for (int y = 0; y < size; y++) {
            sb.append("\n");
            for (int x = 0; x < size; x++) {
                sb.append("| ");
                Piece piece = placedPieces.get(Position.valueOf(x, y));
                sb.append(Piece.toChar(piece));
                sb.append(" ");
            }
            sb.append("|\n");
            sb.append(spacerLine());
        }

//        sb.append(spacerLine());
        return sb.toString();
    }

    private String spacerLine() {
        StringBuilder sb = new StringBuilder(LEFT_POSITION);
        for (int x = 1; x < size; x++) {
            sb.append(POSITION);
        }
        return sb.toString();
    }


}
