package SnakeAndLadderGame;

import java.util.Map;

public class Board {
    private final int size; // number of cells per side
    private final int finalCell; // size*size

    private final Map<Integer, Integer> jumps;
    // key = start cell (snake head or ladder base)
    // value = destination cell (snake tail or ladder top)

    public Board(int size, Map<Integer, Integer> jumps) {
        this.size = size;
        this.finalCell = size * size;
        this.jumps = jumps;
    }

    public int getFinalCell() {
        return finalCell;
    }

    // Given a cell number, returns the cell after applying any snake or ladder.
    // If no jump exists, returns the original cell.
    public int applyJumps(int cell) {
        return jumps.getOrDefault(cell, cell);
    }
}
