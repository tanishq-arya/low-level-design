package SnakeAndLadderGame;

public class Player {
    private final String id;
    private final String name;
    private int position; // start of the board
    private final Character symbol;

    public Player(String id, String name, Character symbol) {
        this.id = id;
        this.name = name;
        this.position = 0;
        this.symbol = symbol;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public int getPosition() {return position;}
    public Character getSymbol() {return symbol;}

    // Moves player to new position
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
