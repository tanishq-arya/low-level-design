package ChessGame;

import ChessGame.Pieces.Piece;

public class Board {
    private final Square[][] grid = new Square[8][8];

    public Board() {
        // Initialize all squares with their coordinates
        for (int file=0; file<8; file++) {
            for (int rank=0; rank<8; rank++) {
                grid[file][rank] = new Square(new Coordinate(file, rank));
            }
        }
    }

    public Square getSquare(Coordinate coordinate) {
        return grid[coordinate.getFile()][coordinate.getRank()];
    }

    public void placePiece(Piece piece, Coordinate coordinate) {
        getSquare(coordinate).setPiece(piece);
        piece.setPosition(coordinate);
    }

    public Piece movePiece(Coordinate from, Coordinate to) {
        Square src = getSquare(from);
        Square dst = getSquare(to);
        Piece moving = src.getPiece();

        if (moving == null) {
            throw new IllegalArgumentException("No piece at " + from);
        }

        // Capture if there is one
        Piece captured = dst.getPiece();

        // Move the piece
        dst.setPiece(moving);
        moving.setPosition(to);
        src.setPiece(null);

        return captured;
    }

    // Prints the board to the console in ranks 8→1, files a→h.
    public void print() {
        for (int rank = 7; rank >= 0; rank--) {
            System.out.print((rank + 1) + "  "); // rank label
            for (int file = 0; file < 8; file++) {
                System.out.print(grid[file][rank] + " ");
            }
            System.out.println();
        }
        System.out.println("\n   a b c d e f g h"); // file labels
    }

    public boolean isPathClear(Coordinate from, Coordinate to) {
        int fileStep = Integer.signum(to.getFile() - from.getFile());
        int rankStep = Integer.signum(to.getRank() - from.getRank());

        int currentFile = from.getFile() + fileStep;
        int currentRank = from.getRank() + rankStep;

        while (currentFile != to.getFile() || currentRank != to.getRank()) {
            if (!grid[currentFile][currentRank].isEmpty()) {
                return false;
            }
            currentFile += fileStep;
            currentRank += rankStep;
        }

        return true;
    }
}