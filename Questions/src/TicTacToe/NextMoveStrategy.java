package TicTacToe;

public class NextMoveStrategy implements MoveStrategy {
    @Override
    public int[] getNextMove(Board board, Symbol symbol) {
        int size = board.getSize();

        // For now find the first empty cell
        // Later on > Min-Max Ai algorithm
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    return new int[]{i, j}; // current row,col
                }
            }
        }
        return null; // no possible move
    }
}