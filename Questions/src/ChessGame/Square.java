package ChessGame;

import ChessGame.Pieces.Piece;

public class Square {
    private final Coordinate coordinate;
    private Piece piece;

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.piece = null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean hasOpponentPiece(Color color) {
        return piece != null && piece.getColor() != color;
    }

    public boolean isEmptyOrOpponent(Color color) {
        return isEmpty() || hasOpponentPiece(color);
    }

    @Override
    public String toString() {
        return isEmpty() ? "." : piece.toString();
    }
}