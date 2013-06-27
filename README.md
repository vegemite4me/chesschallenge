Chess Challenge
==============

My attempt at a solution to the following challenge:
- Place chess pieces on a board such that they cannot attack another piece.
- To start, the server will reply with a message with piece to place.
- When you place that first piece in a position on the board, the server will reply with the next piece to place.
- Each response message contains the current piece to play, and also informs you of what the next piece will be.
- The game ends when you either:
  - Place a piece in an invalid position.
  - The current piece cannot be placed anywhere on the board.
