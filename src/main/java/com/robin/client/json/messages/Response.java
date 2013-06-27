package com.robin.client.json.messages;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;
import com.robin.pieces.Piece;

public final class Response {

    private final List<Link> Links;
    private final String GameId;
    private final Piece CurrentPiece;
    private final Piece NextPiece;
    private final List<PlacedPiece> PlacedPieces;
    private final int Score;
    private final String Message;
    @SerializedName("IsLive")
    private final boolean live;
    private final int Size;
    private final long MillisecondsLeft;

    public Response(List<Link> links, String gameId, Piece currentPiece, Piece nextPiece, List<PlacedPiece> placedPieces, int score, String message, boolean live, int size, long millisecondsLeft) {
        this.Links = Collections.unmodifiableList(links);
        this.GameId = gameId;
        this.CurrentPiece = currentPiece;
        this.NextPiece = nextPiece;
        this.PlacedPieces = Collections.unmodifiableList(placedPieces);
        this.Score = score;
        this.Message = message;
        this.live = live;
        this.Size = size;
        this.MillisecondsLeft = millisecondsLeft;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getGameId() {
        return GameId;
    }

    public Piece getCurrentPiece() {
        return CurrentPiece;
    }

    public Piece getNextPiece() {
        return NextPiece;
    }

    public List<PlacedPiece> getPlacedPieces() {
        return PlacedPieces;
    }

    public int getScore() {
        return Score;
    }

    public String getMessage() {
        return Message;
    }

    public boolean isLive() {
        return live;
    }

    public int getSize() {
        return Size;
    }

    public long getMillisecondsLeft() {
        return MillisecondsLeft;
    }

    public List<Link> getLinks() {
        return Links;
    }
}

