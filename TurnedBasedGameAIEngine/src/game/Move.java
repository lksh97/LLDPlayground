package game;

public class Move {

    private Player player;
    private Cell cell;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Cell getCell() {
        return this.cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}