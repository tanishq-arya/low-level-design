package PrototypePattern.Example.Solution;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard> {
    // State of the pieces -> can be 2d array [][]
    // Taking list for easy understanding
    private final List<GamePiece> pieces = new ArrayList<>();

    public GameBoard() {
    }

    public void addPiece(GamePiece piece) {
        pieces.add(piece);
    }

    public List<GamePiece> getPieces() {
        return pieces;
    }

    public void showBoardState() {
        System.out.println("Current Board State");
        for (GamePiece piece: pieces) {
            System.out.println(piece);
        }
    }

    @Override
    public GameBoard clone() {
        // This is a deep copy**
        GameBoard newBoard = new GameBoard();
        for(GamePiece piece: pieces) {
            newBoard.addPiece(piece.clone());
            // If addPiece(piece) > shallow copy
            // Both boards would've shared same piece object
            // Which could be modified by any of the boards
        }
        return newBoard;
    }
}