import java.util.Scanner;

import api.GameEngine;
import game.Board;
import game.Player;
import game.Move;
import game.Cell;

public class Main {
    public static void main(String[] args) {
        
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        Scanner scanner = new Scanner(System.in);;
        int row, col;

        //make moves in a loop
        while(gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("O"), human = new Player("X");
            System.out.println("Make your move!");

            System.out.println(board);

            row = scanner.nextInt();
            col = scanner.nextInt();

            Move oppMove = new Move(new Cell(row, col));
            gameEngine.move(board, human, oppMove);

            if(!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
        }

        System.out.println("GameResult: "+ gameEngine.isComplete(board));
        System.out.println(board);
    }
}
