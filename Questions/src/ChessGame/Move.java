package ChessGame;

import ChessGame.Pieces.Piece;

public class Move {
    private final Coordinate from;
    private final Coordinate to;
    private final Piece movedPiece;
    private final Piece capturedPiece;

    public Move(Coordinate from, Coordinate to, Piece movedPiece, Piece capturedPiece) {
        this.from = from;
        this.to = to;
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
    }

    public Coordinate getFrom() { return from; }
    public Coordinate getTo()   { return to; }
    public Piece getMovedPiece()   { return movedPiece; }
    public Piece getCapturedPiece(){ return capturedPiece; }

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}