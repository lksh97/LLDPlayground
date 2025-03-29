package boards;

import game.Cell;
import game.Board;
import game.Move;

/**
 * TicTacToeBoard extends Board, which exists in a different package.
 *
 * Some people might ask why Board and TicTacToeBoard are in separate packages
 * since they are related. It’s a valid question, but not necessarily an anti-pattern.
 * This separation is intentional — if this board is part of the game, the modular
 * split is fine.
 *
 * Also, not all board types necessarily need cells — we introduce `cells` here
 * specifically for TicTacToeBoard.
 */
public class TicTacToeBoard extends Board {
    // 3x3 grid representing the TicTacToe board
    private final String[][] cells = new String[3][3]; // cells marked private final (encapsulation + immutability of reference).

    /**
     * Returns the symbol at a specific row and column.
     *
     * @param row Row index (0-based)
     * @param col Column index (0-based)
     * @return Symbol at the given cell or null if empty
     */
    public String getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Sets a player's symbol at a given cell.
     *
     * @param cell   Cell object with row and column
     * @param symbol Player's symbol (e.g., "X" or "O")
     */
    public void setCell(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }

    /**
     * Returns a string representation of the board,
     * using "-" to represent empty cells.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(cells[i][j] == null ? "-" : cells[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public void move(Move move) {
        setCell(move.getCell(), move.getPlayer().symbol());
    }
}
