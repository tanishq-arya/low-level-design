package PrototypePattern.Example.Solution;

public class GameClientWithPrototype {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(); // New board
        board.addPiece(new GamePiece("Red", 1));
        board.addPiece(new GamePiece("Blue", 2));

        System.out.println("Original Board");
        board.showBoardState();

        // Checkpoint this state -> save current state
        System.out.println("Checkpoint > Saving board state");

        // Decoupled implementation > Client doesn't need to know inside
        GameBoard copiedBoard = board.clone();

        System.out.println("Copied Board");
        copiedBoard.showBoardState();
    }
}