package com.robin.position;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class PositionCache {

    private final static ConcurrentMap<String, Position> positionByCoordinates = new ConcurrentHashMap<String, Position>();

    private PositionCache() { }

    /**
     * Intended to be used by Position.valueOf()
     */
    static Position get(int x, int y) {
        final String key = new StringBuilder("").append(x).append(".").append(y).toString();
        Position position = positionByCoordinates.get(key);
        if (position == null) {
            position = new Position(x, y);
            Position existing = positionByCoordinates.putIfAbsent(key, position);
            if (existing != null) {
                position = existing;
            }
        }
        return position;
    }
}
