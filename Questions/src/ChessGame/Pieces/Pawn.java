package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        int dir = (color == Color.WHITE) ? 1 : -1;
        int startRow = (color == Color.WHITE) ? 1 : 6;

        int fileDiff = to.getFile() - from.getFile();
        int rankDiff = to.getRank() - from.getRank();

        Piece destPiece = board.getSquare(to).getPiece();

        // Standard forward move
        if (fileDiff == 0) {
            if (rankDiff == dir && destPiece == null) return true;
            if (rankDiff == 2 * dir && from.getRank() == startRow && destPiece == null) {
                // Check intermediate square is also empty
                Coordinate mid = new Coordinate(from.getFile(), from.getRank() + dir);
                return board.getSquare(mid).isEmpty();
            }
        }

        // Diagonal capture
        if (Math.abs(fileDiff) == 1 && rankDiff == dir && destPiece != null && destPiece.getColor() != color) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}