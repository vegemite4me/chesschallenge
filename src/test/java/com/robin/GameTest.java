package com.robin;

import org.junit.Test;

import com.robin.client.Client;
import com.robin.client.FixedSequenceClient;

public class GameTest {

    @Test
    public void testPlay() throws Exception {
        // Given
        AnyValidPositionStrategy strategy = new AnyValidPositionStrategy();
        Client client = new FixedSequenceClient("Knight", "Knight", "Knight", "Knight", "Knight", "King");
        Game game = new Game(client, strategy);

        // When
        game.play(5);

    }
}
