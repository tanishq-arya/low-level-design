package ChessGame.Pieces;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Coordinate;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, Board board) {
        if (from.equals(to)) return false;

        boolean sameRow = from.getRank() == to.getRank();
        boolean sameCol = from.getFile() == to.getFile();

        if (sameRow || sameCol) {
            return board.isPathClear(from, to) &&
                    board.getSquare(to).isEmptyOrOpponent(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}