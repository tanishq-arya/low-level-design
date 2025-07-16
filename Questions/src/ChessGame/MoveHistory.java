package ChessGame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MoveHistory {
    private final Deque<Move> undoStack = new ArrayDeque<>();

    /** Record a new move — clears the redo stack. */
    public void recordMove(Move move) {
        undoStack.push(move);
    }

    /** Returns true if there is at least one move to undo. */
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    /** Pops the last move and makes it available to redo. */
    public Move undo() {
        if (!canUndo()) throw new IllegalStateException("Nothing to undo");
        return undoStack.pop();
    }

    /** Returns the list of all moves in order they were played. */
    public List<String> getHistory() {
        return undoStack.stream()
                .toList()
                .stream().map(Move::toString).toList();
    }
}
