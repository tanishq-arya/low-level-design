package PrototypePattern.Example.Problem;

public class GameClientWithoutPrototype {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(); // New board
        board.addPiece(new GamePiece("Red", 1));
        board.addPiece(new GamePiece("Blue", 2));

        System.out.println("Original Board");
        board.showBoardState();

        // Checkpoint this state -> save current state
        System.out.println("Checkpoint > Saving board state");

        GameBoard copiedBoard = new GameBoard();
        for(GamePiece piece: board.getPieces()) {
            copiedBoard.addPiece(new GamePiece(piece.getColor(), piece.getPosition()));
        }

        System.out.println("Copied Board");
        copiedBoard.showBoardState();

        // Problem >
        // 1. We exposed the piece
        // 2. Piece and client are tightly coupled > Less flexible
        // 3. Manual copy > Client wants a copy > should be in board and not client
        // Solution > each class should create copy itself
    }
}