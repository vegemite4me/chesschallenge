package com.robin.pieces;

import java.util.Set;

import com.robin.position.Position;

public abstract class Piece {

    public abstract Set<Position> getAttackablePositions(int boardSize, Position position);

    public abstract String toChar();

    public static Piece valueOf(String s) {
        if ("King".equals(s)) return new King();
        else if ("Queen".equals(s)) return new Queen();
        else if ("Rook".equals(s)) return new Rook();
        else if ("Knight".equals(s)) return new Knight();
        else if ("Bishop".equals(s)) return new Bishop();
        throw new IllegalArgumentException("Unknown piece: " + s);
    }

    public static String toChar(Piece piece) {
        if (piece != null) {
            return piece.toChar();
        }
        return " ";
    }
}
