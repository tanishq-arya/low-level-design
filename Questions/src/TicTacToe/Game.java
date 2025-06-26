package TicTacToe;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentPlayerIdx; // to maintain turns
    private GameStatus status;

    public Game(int boardSize, List<Player> players) {
        this.board = new Board(boardSize);
        this.players = players;

        // default values
        this.status = GameStatus.IN_PROGRESS;
        this.currentPlayerIdx = 0;
    }

    public void start() {
        while (status == GameStatus.IN_PROGRESS) {
            board.printBoard();

            Player currentPlayer = players.get(currentPlayerIdx);
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            int row, col;
            if (currentPlayer instanceof AIPlayer) {
                int[] move = ((AIPlayer) currentPlayer).makeMove(board);
                row = move[0];
                col = move[1];
                System.out.println("AI chooses: (" + row + ", " + col + ")");
            } else {
                row = getInput("Enter row: ");
                col = getInput("Enter column: ");
            }

            // Check move > is valid move ?
            if (!board.setSymbolAt(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // check if current placement is winning move
            if (checkWinner(row, col, currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                status = GameStatus.WIN;
                break;
            }

            // check if current placement is last move
            if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                status = GameStatus.DRAW;
                break;
            }

            // move to next player's turn
            switchTurn();
        }
    }

    private boolean checkWinner(int row, int col, Symbol symbol) {
        int n = board.getSize();
        boolean winRow = true, winCol = true, winDiag = true, winAntiDiag = true;
        for (int i = 0; i < n; i++) {
            if (board.getSymbolAt(row, i) != symbol) winRow = false;
            if (board.getSymbolAt(i, col) != symbol) winCol = false;
            if (board.getSymbolAt(i, i) != symbol) winDiag = false;
            if (board.getSymbolAt(i, n - i - 1) != symbol) winAntiDiag = false;
        }

        return winRow || winCol || winDiag || winAntiDiag;
    }

    private void switchTurn() {
        // rotate turns
        currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
    }

    private int getInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }
}