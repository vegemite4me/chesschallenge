package com.robin.client.json.messages.util;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.robin.pieces.Piece;

public class PieceJsonDeserializer implements JsonDeserializer<Piece> {

    @Override
    public Piece deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Piece.valueOf(jsonElement.getAsString());
    }
}
