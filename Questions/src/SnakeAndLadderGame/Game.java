package SnakeAndLadderGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game implements Runnable {
    private final String id;
    private final Board board;
    private final List<Player> players;
    private final Die die;
    private int currentPlayerIdx = 0;
    private boolean isFinished = false;

    public Game(String id, Board board, List<Player> players, Die die) {
        this.id = id;
        this.board = board;
        this.players = players;
        this.die = die;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting game: " + id + " with players: " + players);

        int lastCell = board.getFinalCell();

        while (!isFinished) {
            Player currentPlayer = players.get(currentPlayerIdx);
            System.out.println(currentPlayer.getName() + "'s turn. Press ENTER to roll the die.");
            scanner.nextLine();

            int roll = die.roll();
            System.out.println("Rolled a " + roll);

            int tentative = currentPlayer.getPosition() + roll;

            // Handle overshoot bounce
            if (tentative > lastCell) {
                int overshoot = tentative - lastCell;
                tentative = lastCell - overshoot;
                System.out.println("Overshoot! Bouncing back to " + tentative);
            }

            // Apply snakes or ladders
            int landed = board.applyJumps(tentative);
            if (landed != tentative) {
                String type = (landed > tentative) ? "LADDER" : "SNAKE";
                System.out.printf("Hit a %s! Moving from %d to %d%n",
                        type, tentative, landed);
            }

            currentPlayer.setPosition(landed);
            System.out.println(currentPlayer.getName() +
                    " is now on cell " + currentPlayer.getPosition());

            // Print after move
            printBoard();

            // Check for win
            if (currentPlayer.getPosition() == lastCell) {
                System.out.println(currentPlayer.getName() + " WINS!");
                isFinished = true;
                break;
            }

            // Next player
            currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
        }

        System.out.println("Game " + id + " over.");
    }

    /** Renders the board in console, marking each player's position. */
    private void printBoard() {
        int n = board.getFinalCell() == 100 ? 10 : (int)Math.sqrt(board.getFinalCell());
        Map<Integer, String> cellMarkers = new HashMap<>();

        // Build a map of cell → player initials (if multiple on same cell, concatenate)
        for (Player p : players) {
            cellMarkers.merge(
                    p.getPosition(),
                    p.getName().substring(0,1).toUpperCase(),
                    String::concat
            );
        }

        System.out.println();
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int cellNum = row * n + col + 1;
                String marker = cellMarkers.getOrDefault(cellNum, String.valueOf(cellNum));
                // pad to width=4 for alignment
                System.out.printf("%4s", marker);
            }
            System.out.println();
        }
        System.out.println();
    }
}