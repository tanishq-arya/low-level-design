package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        int fileDiff = Math.abs(from.getFile() - to.getFile());
        int rankDiff = Math.abs(from.getRank() - to.getRank());

        boolean isLShaped = (fileDiff == 2 && rankDiff == 1) || (fileDiff == 1 && rankDiff == 2);

        return isLShaped && board.getSquare(to).isEmptyOrOpponent(this.color);
    }

    @Override
    public String getSymbol() {
        return "N";
    }
}