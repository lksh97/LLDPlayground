package api;
// Requirement : Taking a game and having the ability to play it through AI.

import boards.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.GameResult;
import game.Move;
import game.Player;


public class GameEngine {
    // public static void main(String[] args) {

    // }

    // There should be a function to start the game and if it's a board game let's say. It should return the a Board to play-on
    public Board start(String type) {
        if(type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }
    }


    
    // GameEngine.move utilizes three classes for setting the character at a specified position: Move, Cell, and Board.

    // - `Move` encapsulates the position using the `Cell` class.
    // - `Board` employs `Move` to set the character.

    // Example:
    // - `move.get_cell()` yields a cell object with row and column.
    // - `board.set_cell(move.get_cell(), position.symbol())` uses the row and column from `Cell` in `Move` to replace with the player's symbol.

    // There should be method that makes a move for a user for a particular game
    public void move(Board board, Player player, Move move) {
        if(board instanceof TicTacToeBoard) {

            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(Move.getCell(), player.symbol());
        } else {
            throw new IllegalStateException();
        }
    }

    // The isComplete method doesn't simply return a Boolean value. Instead, it returns a GameResult object. This design choice is made because, upon the completion of a game, it's not just about whether the game is complete or not (a Boolean value), but also about who has won the game.
    public GameResult isComplete(Board board) {

        if(board instanceof TicTacToeBoard) {

            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-";
            boolean rowComplete = true;
            for(int i=0;i<3;i++) {
                rowComplete = true;
                // these cells as default types will not be accessible
                // firstCharacter = board1.cells[i][0];
                // Where to put this getCell method??
                // -- If boards cn exist without cells then we should not put cells in boards.
                firstCharacter = board1.getCell(i, 0);

                rowComplete = firstCharacter!=null; // FIX: java.lang.NullPointerException
                if(firstCharacter!=null) { // FIX: java.lang.NullPointerException
                    for(int j=1;j<3;j++) {
                        // java.lang.NullPointerException: If the first character of the row is null, then the row is not complete

                        //ERROR: java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because the return value of "boards.TicTacToeBoard.getCell(int, int)" is null

                        // if(!(board1.getCell(i, j)).equals(firstCharacter)) {
                        if(!(firstCharacter.equals(board1.getCell(i, j)))) {
                            rowComplete = false;
                            break; // optimisation1
                        }
                    }
                }

                if(rowComplete) {
                    break; // optimisation2
                }
            }

            if(rowComplete) {
                return new GameResult(true, firstCharacter); // optimisation3
            }

            boolean colComplete = true;
            for(int i=0;i<3;i++) {
                firstCharacter = board1.getCell(0, i);
                colComplete = firstCharacter!=null; // FIX: java.lang.NullPointerException
                if(firstCharacter!=null) { // FIX: java.lang.NullPointerException
                    for(int j=1;j<3;j++) {
                        // ERROR: Cannot invoke "String.equals(Object)" because the return value of "boards.TicTacToeBoard.getCell(int, int)" is null

                        // if(!(board1.getCell(j, i)).equals(firstCharacter)) {
                        if(!(firstCharacter).equals(board1.getCell(j, i))) {

                            colComplete = false;
                            break;
                        }
                    }
                }
            }

            if(colComplete) {
                return new GameResult(true, firstCharacter);
            }

            boolean diagComplete = true;
            firstCharacter = board1.getCell(0, 0);
            for(int i=0;i<3;i++) {
                // diagComplete = true;
                // if(firstCharacter!=null && !(board1.getCell(i, i).equals(firstCharacter))) {
                if(firstCharacter!=null && !(firstCharacter.equals(board1.getCell(i, i)))) {
                    diagComplete = false;
                    break;
                }
            }

            if(diagComplete) {
                return new GameResult(true, firstCharacter);
            }

            boolean revDiagComplete = true;
            firstCharacter = board1.getCell(0, 2); //board1.cells[0][2];
            for(int i=0;i<3;i++) {
                // revDiagComplete = true;
                if(firstCharacter!=null &&  !(board1.getCell(i, 2-i)).equals(firstCharacter )) {
                    revDiagComplete = false;
                    break;
                }
            }

            if(revDiagComplete) {
                return new GameResult(true, firstCharacter);
            }

            // if(rowComplete || colComplete || diagComplete || revDiagComplete) {
            //     return new GameResult();
            // }

            // To check whether all cells are filled and although nobody wins (Is it  draw)
            int countOfFilledCells = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if((board1.getCell(i, j))!=null) {
                        countOfFilledCells++;
                    }
                }
            }

            if(countOfFilledCells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }

        }

        return null;
    }

    public Move suggestMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;

            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if((board1.getCell(i, j)) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }

            throw new IllegalArgumentException();

        } else {
            throw new IllegalArgumentException();
        }
    }
}

// class Player {

// }

// class Move {

// }

// class GameResult {
//     boolean isOver;
//     String winner;

//     public GameResult(boolean isOver, String winner) {
//         this.isOver = isOver;
//         this.winner = winner;
//     }
// }

