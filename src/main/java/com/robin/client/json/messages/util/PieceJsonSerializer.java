package com.robin.client.json.messages.util;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robin.pieces.Piece;

public class PieceJsonSerializer implements JsonSerializer<Piece> {

    @Override
    public JsonElement serialize(Piece piece, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(piece.toString());
    }
}
