package boards;
import game.Cell;
import game.Board;

// TicTacToeBoard extends Board, that is in different pkg. Some people think why don't we move it together, since they are related. It isn't an anti-pattern this is how I want to define it. If this board is part of game it is fine.

// All boards might not have, we shall introduce cells in TicTacToeBoard
public class TicTacToeBoard extends Board {
    String cells[][] = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(Cell cell, String symbol) {
        cells[cell.row][cell.col] = symbol;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                result.append(cells[i][j]==null? "-" : cells[i][j]);
            }
            result.append("\n");
        }

        return result.toString();
    }
}