package TicTacToe;

public class AIPlayer extends Player {
    private final MoveStrategy strategy;

    public AIPlayer(String name, Symbol symbol, MoveStrategy strategy) {
        super(name, symbol);
        this.strategy = strategy;
    }

    public int[] makeMove(Board board) {
        return strategy.getNextMove(board, this.getSymbol());
    }
}