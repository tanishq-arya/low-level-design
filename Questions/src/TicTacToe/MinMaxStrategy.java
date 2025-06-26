package TicTacToe;

public class MinMaxStrategy implements MoveStrategy {
    @Override
    public int[] getNextMove(Board board, Symbol symbol) {
        // check if it works > copied from GPT
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.isValidMove(i, j)) {  // valid position
                    // Recursion to check the score in this position

                    board.makeMove(i, j, symbol); // makeMove
                    int score = minimax(board, false, symbol, getOpponent(symbol));
                    board.undoMove(i, j); // undoMove

                    // update score if better
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }

        // if no result
        if (bestMove == null) {
            return new NextMoveStrategy().getNextMove(board, symbol);
        }
        return bestMove;
    }
    private int minimax(Board board, boolean isMaximizing, Symbol aiSymbol, Symbol opponent) {
        if (board.hasWinner(aiSymbol)) return 1;
        if (board.hasWinner(opponent)) return -1;
        if (board.isFull()) return 0;

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.isValidMove(i, j)) {
                    board.makeMove(i, j, isMaximizing ? aiSymbol : opponent);
                    int score = minimax(board, !isMaximizing, aiSymbol, opponent);
                    board.undoMove(i, j);
                    bestScore = isMaximizing
                            ? Math.max(score, bestScore)
                            : Math.min(score, bestScore);
                }
            }
        }

        return bestScore;
    }

    private Symbol getOpponent(Symbol symbol) {
        return symbol == Symbol.X ? Symbol.O : Symbol.X;
    }
}