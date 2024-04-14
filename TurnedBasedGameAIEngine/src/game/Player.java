package game;

public class Player {
    
    private String playerSymbol;

    public Player(String symbol) {
        this.playerSymbol = symbol;
    }

    public String symbol() {
        return playerSymbol;
    }
}
