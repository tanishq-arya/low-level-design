package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        int fileDiff = Math.abs(from.getFile() - to.getFile());
        int rankDiff = Math.abs(from.getRank() - to.getRank());

        // King can move one square in any direction
        if ((fileDiff <= 1 && rankDiff <= 1) && !(fileDiff == 0 && rankDiff == 0)) {
            Piece destPiece = board.getSquare(to).getPiece();
            // destination is empty or opponent -> legal capture
            return destPiece == null || destPiece.getColor() != this.color;
        }

        // Castling can be added later
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}