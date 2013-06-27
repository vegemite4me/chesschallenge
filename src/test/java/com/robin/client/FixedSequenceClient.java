package com.robin.client;

import java.util.Arrays;
import java.util.List;

import com.robin.pieces.Piece;
import com.robin.position.Position;

public class FixedSequenceClient implements Client {

    private final List<String> sequenceOfPieces;
    private int count = 0;

    public FixedSequenceClient(String ... sequenceOfPieces) {
        this.sequenceOfPieces = Arrays.asList(sequenceOfPieces);
    }

    @Override
    public Piece startGameAndGetFirstPiece(int boardSize) {
        return placeCurrentPiece(null);
    }

    @Override
    public Piece startTournamentAndGetFirstPiece(String playerId) {
        return placeCurrentPiece(null);
    }

    @Override
    public Piece placeCurrentPiece(Position position) {
        if (count >= sequenceOfPieces.size()) {
            return Piece.valueOf(sequenceOfPieces.get(sequenceOfPieces.size() - 1));
        }
        return Piece.valueOf(sequenceOfPieces.get(count++));
    }

}
