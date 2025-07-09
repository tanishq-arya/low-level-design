package ChessGame;

import ChessGame.Pieces.*;

import java.util.*;

// CLI Chess game for two human players with undo support.
public class Game {
    private final Board board = new Board();
    private Color currentTurn = Color.WHITE;
    private final Deque<Move> history = new ArrayDeque<>();

    public void start() {
        setupInitialPosition();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.print();
            System.out.println(currentTurn + "'s move (e.g. e2 e4, or 'undo'): ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("undo")) {
                if (!history.isEmpty()) {
                    undoLastMove();
                    currentTurn = currentTurn.opposite();
                } else {
                    System.out.println("Nothing to undo.");
                }
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Use 'e2 e4' or 'undo'.");
                continue;
            }

            try {
                Coordinate from = Coordinate.fromAlgebraic(parts[0]);
                Coordinate to   = Coordinate.fromAlgebraic(parts[1]);
                if (!makeMove(from, to)) {
                    System.out.println("Illegal move, try again.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            // TODO: Check for checkmate/stalemate here
            // if (isCheckmate(currentTurn.opposite())) { ... }

            currentTurn = currentTurn.opposite();
        }
    }

    private void setupInitialPosition() {
        // Pawns
        for (int file = 0; file < 8; file++) {
            board.placePiece(new Pawn(Color.WHITE), new Coordinate(file, 1));
            board.placePiece(new Pawn(Color.BLACK), new Coordinate(file, 6));
        }
        // Rooks
        board.placePiece(new Rook(Color.WHITE), new Coordinate(0, 0));
        board.placePiece(new Rook(Color.WHITE), new Coordinate(7, 0));
        board.placePiece(new Rook(Color.BLACK), new Coordinate(0, 7));
        board.placePiece(new Rook(Color.BLACK), new Coordinate(7, 7));
        // Knights
        board.placePiece(new Knight(Color.WHITE), new Coordinate(1, 0));
        board.placePiece(new Knight(Color.WHITE), new Coordinate(6, 0));
        board.placePiece(new Knight(Color.BLACK), new Coordinate(1, 7));
        board.placePiece(new Knight(Color.BLACK), new Coordinate(6, 7));
        // Bishops
        board.placePiece(new Bishop(Color.WHITE), new Coordinate(2, 0));
        board.placePiece(new Bishop(Color.WHITE), new Coordinate(5, 0));
        board.placePiece(new Bishop(Color.BLACK), new Coordinate(2, 7));
        board.placePiece(new Bishop(Color.BLACK), new Coordinate(5, 7));
        // Queens
        board.placePiece(new Queen(Color.WHITE), new Coordinate(3, 0));
        board.placePiece(new Queen(Color.BLACK), new Coordinate(3, 7));
        // Kings
        board.placePiece(new King(Color.WHITE), new Coordinate(4, 0));
        board.placePiece(new King(Color.BLACK), new Coordinate(4, 7));
    }

    /** Attempts to make a move; returns true if successful. */
    private boolean makeMove(Coordinate from, Coordinate to) {
        Square src = board.getSquare(from);
        Piece piece = src.getPiece();
        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }
        if (!piece.isValidMove(from, to, board)) {
            return false;
        }
        // Execute move
        Piece captured = board.movePiece(from, to);
        history.push(new Move(from, to, piece, captured));
        return true;
    }

    /** Undo the last move, restoring board state. */
    private void undoLastMove() {
        Move last = history.pop();
        // Move piece back
        board.movePiece(last.getTo(), last.getFrom());
        last.getMovedPiece().setPosition(last.getFrom());
        // Restore captured piece if any
        if (last.getCapturedPiece() != null) {
            board.placePiece(last.getCapturedPiece(), last.getTo());
        }
        System.out.println("Undid move "
                + last.getMovedPiece().getSymbol()
                + " from " + last.getFrom()
                + " to " + last.getTo());
    }

    // TODO: implement proper check/checkmate detection
    private boolean isCheckmate(Color defender) {
        return false;
    }
}