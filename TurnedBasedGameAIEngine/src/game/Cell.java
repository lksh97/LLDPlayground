package game;

public class Cell {

    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }


    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}
