package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        if (from.equals(to)) return false;

        int fileDiff = Math.abs(from.getFile() - to.getFile());
        int rankDiff = Math.abs(from.getRank() - to.getRank());

        if (fileDiff == rankDiff) {
            return board.isPathClear(from, to) &&
                    board.getSquare(to).isEmptyOrOpponent(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}