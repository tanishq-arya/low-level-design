package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public abstract class Piece {
    protected final Color color;
    protected Coordinate position;

    protected Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    // Each piece must define its movement logic
    public abstract boolean isValidMove(Coordinate from, Coordinate to, Board board);

    @Override
    public String toString() {
        return color == Color.WHITE ? getSymbol().toUpperCase() : getSymbol().toLowerCase();
    }

    public abstract String getSymbol(); // "P" -> pawn
}