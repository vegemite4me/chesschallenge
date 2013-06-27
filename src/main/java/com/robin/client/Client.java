package com.robin.client;

import com.robin.pieces.Piece;
import com.robin.position.Position;

public interface Client {

    Piece startGameAndGetFirstPiece(int boardSize);
    Piece startTournamentAndGetFirstPiece(String playerId);
    Piece placeCurrentPiece(Position position);
}
