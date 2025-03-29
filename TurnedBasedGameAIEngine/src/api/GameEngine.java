package api;

// Requirement: Taking a game and having the ability to play it through AI.

import boards.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.GameResult;
import game.Move;
import game.Player;

public class GameEngine {

    /**
     * Starts a new game of the specified type.
     *
     * @param type The type of game (currently only "TicTacToe" is supported).
     * @return Board instance of the corresponding game.
     */
    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Unsupported game type: " + type);
        }
    }

    /**
     * Makes a move on the board for the specified player.
     *
     * @param board  The game board.
     * @param player The player making the move.
     * @param move   The move to make.
     */
    // State of the board is changing but why through a game engine? Why this API is being exposed in a game engine
   public void move(Board board, Player player, Move move) {
       if (board instanceof TicTacToeBoard) {
           TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
           ticTacToeBoard.setCell(move.getCell(), player.symbol()); // the game engine is setting up the board instead it should just call board.move(move) why?
           // If move is being made, then move should store the info for which player is making the move.
       } else {
           throw new IllegalStateException("Unsupported board type.");
       }
   }

    public void move(Board board, Move move) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            ticTacToeBoard.move(move);
        } else {
            throw new IllegalStateException("Unsupported board type.");
        }
    }

    /**
     * Checks if the game is complete and returns the result.
     *
     * @param board The game board.
     * @return GameResult object indicating whether the game is complete and the winner.
     */
    public GameResult isComplete(Board board) {
        if (!(board instanceof TicTacToeBoard)) {
            return null;
        }

        TicTacToeBoard tttBoard = (TicTacToeBoard) board;

        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            String first = tttBoard.getCell(i, 0);
            if (first != null && first.equals(tttBoard.getCell(i, 1)) && first.equals(tttBoard.getCell(i, 2))) {
                return new GameResult(true, first);
            }
        }

        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            String first = tttBoard.getCell(0, i);
            if (first != null && first.equals(tttBoard.getCell(1, i)) && first.equals(tttBoard.getCell(2, i))) {
                return new GameResult(true, first);
            }
        }

        // Check diagonal
        String center = tttBoard.getCell(1, 1);
        if (center != null) {
            if (center.equals(tttBoard.getCell(0, 0)) && center.equals(tttBoard.getCell(2, 2))) {
                return new GameResult(true, center);
            }
            if (center.equals(tttBoard.getCell(0, 2)) && center.equals(tttBoard.getCell(2, 0))) {
                return new GameResult(true, center);
            }
        }

        // Check for draw (all cells filled, no winner)
        int filledCells = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tttBoard.getCell(i, j) != null) {
                    filledCells++;
                }
            }
        }

        if (filledCells == 9) {
            return new GameResult(true, "-"); // Draw
        }

        return new GameResult(false, "-"); // Game still in progress
    }

    /**
     * Suggests a move for the AI/computer player.
     *
     * @param computer The computer player.
     * @param board    The current game board.
     * @return A Move object representing the suggested move.
     */
    public Move suggestMove(Player computer, Board board) {
        if (!(board instanceof TicTacToeBoard)) {
            throw new IllegalArgumentException("Unsupported board type.");
        }

        TicTacToeBoard tttBoard = (TicTacToeBoard) board;

        // Naive strategy: return the first available cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tttBoard.getCell(i, j) == null) {
                    return new Move(new Cell(i, j), computer);
                }
            }
        }

        throw new IllegalArgumentException("No moves available.");
    }
}
