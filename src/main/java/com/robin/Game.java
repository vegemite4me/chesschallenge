package com.robin;

import com.robin.client.Client;
import com.robin.client.JsonClient;
import com.robin.pieces.Piece;
import com.robin.position.Position;

import static com.google.common.base.Preconditions.checkArgument;

// 32 http://stomv10886:8080
// 8 http://localhost:8080
public class Game {

    private final Client client;
    private final Strategy strategy;
    private final String playerId;

    public static final void main(String[] args) {
        checkArgument(args.length >= 2 && args.length <= 3);

        int boardSize = Integer.valueOf(args[0]);
        String endPoint = args[1];
        String playerId = null;

        if (args.length > 2) {
            playerId = args[2];
        }

        Client client = new JsonClient(endPoint);
//        Strategy strategy = new AnyValidPositionStrategy();
        Strategy strategy = new LeastCostlyPositionStrategy();

        Game game = new Game(client, strategy, playerId);

        long start = System.currentTimeMillis();
        game.play(boardSize);
        long end = System.currentTimeMillis();
        System.out.println("The game took " + (end-start) + "ms.");
    }

    public Game(Client client, Strategy strategy) {
        this(client, strategy, null);
    }

    public Game(Client client, Strategy strategy, String playerId) {
        this.client = client;
        this.strategy = strategy;
        this.playerId = playerId;
    }

    public void play(int boardSize) {

        Board board = BoardFactory.createBoard(boardSize);

        Position positionToPlaceIn;

        int i = 0;

        Piece nextPiece;
        if (playerId != null) {
            nextPiece = client.startTournamentAndGetFirstPiece(playerId);
        } else {
            nextPiece = client.startGameAndGetFirstPiece(boardSize);
        }

        positionToPlaceIn = strategy.calculatePositionToPlace(nextPiece, boardSize, board.getAvailablePositions(), board.getTakenPositions());
        if (positionToPlaceIn != null) {
            board.place(positionToPlaceIn, nextPiece);
        }

        do {
            nextPiece = client.placeCurrentPiece(positionToPlaceIn);
            positionToPlaceIn = strategy.calculatePositionToPlace(nextPiece, boardSize, board.getAvailablePositions(), board.getTakenPositions());
            if (positionToPlaceIn != null) {
                board.place(positionToPlaceIn, nextPiece);
            }
            i++;
        } while (positionToPlaceIn != null);
        System.out.println("After placing " + i + " pieces.");
        System.out.println(board);
    }
}
