package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        if (from.equals(to)) return false;

        int fileDiff = Math.abs(from.getFile() - to.getFile());
        int rankDiff = Math.abs(from.getRank() - to.getRank());

        boolean sameRow = from.getRank() == to.getRank();
        boolean sameCol = from.getFile() == to.getFile();
        boolean sameDiagonal = fileDiff == rankDiff;

        if (sameRow || sameCol || sameDiagonal) {
            return board.isPathClear(from, to) &&
                    board.getSquare(to).isEmptyOrOpponent(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}