package com.robin.position;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValid(int boardSize) {
        return  x >= 0 &&
                y >= 0 &&
                x < boardSize &&
                y < boardSize;
    }

    public Position left() {
        return Position.valueOf(x-1, y);
    }

    public Position right() {
        return Position.valueOf(x+1, y);
    }

    public Position up() {
        return Position.valueOf(x, y-1);
    }

    public Position down() {
        return Position.valueOf(x, y+1);
    }

    public Position upLeft() {
        return Position.valueOf(x-1, y-1);
    }
    public Position upRight() {
        return Position.valueOf(x+1, y-1);
    }
    public Position downLeft() {
        return Position.valueOf(x-1, y+1);
    }
    public Position downRight() {
        return Position.valueOf(x+1, y+1);
    }

    public static Position valueOf(int x, int y) {
        return PositionCache.get(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
