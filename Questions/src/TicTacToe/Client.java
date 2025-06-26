package TicTacToe;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("==== Starting Game ====");

        // 2-Player game
        Player p1 = new Player("Alice", Symbol.X);
        // Player p2 = new Player("Bob", Symbol.O);

        // AI-player
        Player ai = new AIPlayer("AI", Symbol.O, new NextMoveStrategy());

        Game game = new Game(3, List.of(p1, ai));
        game.start();
    }
}