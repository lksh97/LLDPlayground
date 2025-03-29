import java.util.Scanner;

import api.GameEngine;
import game.Board;
import game.Player;
import game.Move;
import game.Cell;

/**
 * Main class to run the TicTacToe game using GameEngine.
 *
 * The user plays against a basic AI (computer) that picks the first available cell.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize game engine and start a TicTacToe game
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Define players
        Player human = new Player("X");
        Player computer = new Player("O");

        // Main game loop: continues until game is over
        while (!gameEngine.isComplete(board).isOver()) {
            System.out.println("Your Move (Enter row and column between 0-2):");
            System.out.println(board); // Show current state of the board

            // Read user input for move
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Create move object and update board with human move
            Move humanMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, humanMove);

            // If the game isn't over after human move, let computer make a move
            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }

        // Game has ended; print final result and board
        System.out.println("Game Over!");
        System.out.println("Result: " + gameEngine.isComplete(board)); // Shows winner or draw
        System.out.println(board); // Final board state

        scanner.close();
    }
}
