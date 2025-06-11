package PrototypePattern.Example.Problem;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
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
}