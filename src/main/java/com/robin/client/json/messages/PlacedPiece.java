package com.robin.client.json.messages;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.robin.pieces.Piece;

public final class PlacedPiece {

    private final Piece Piece;
    private final int Row;
    private final int Column;

    public PlacedPiece(Piece piece, int row, int column) {
        this.Piece = piece;
        this.Row = row;
        this.Column = column;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Piece getPiece() {
        return Piece;
    }

    public int getRow() {
        return Row;
    }

    public int getColumn() {
        return Column;
    }
}
