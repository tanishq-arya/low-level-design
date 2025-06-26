package TicTacToe;

public interface MoveStrategy {
    int[] getNextMove(Board board, Symbol symbol);
}