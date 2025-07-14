package SnakeAndLadderGame;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        Map<Integer,Integer> jumps = Map.ofEntries(
                Map.entry(16, 6),  // snake: head 16 → tail 6
                Map.entry(48, 30), // snake: 48 → 30
                Map.entry(2, 38),  // ladder: 2 → 38
                Map.entry(15, 26)  // ladder: 15 → 26
        );

        // 2) Create board (10×10 → 100 cells)
        Board board = new Board(10, jumps);

        // 3) Create players
        List<Player> players = List.of(
                new Player("P1", "Alice", 'A'),
                new Player("P2", "Bob", 'B')
        );

        // 4) Start a game session
        Game session = new Game(
                UUID.randomUUID().toString(),
                board,
                players,
                new Die()
        );

        // 5) Run it (in this demo we run on main thread)
        session.run();
    }
}
