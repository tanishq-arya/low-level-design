package TicTacToe;

public class Board {
    private final int size;
    private final Cell [][] grid;
    private Symbol lastSymbol;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];

        // init grid
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean setSymbolAt(int row, int col, Symbol symbol) {
        // check if move is valid
        if (isValidMove(row, col)) {
            grid[row][col].setSymbol(symbol);
            return true;
        }

        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col].isEmpty();
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j].isEmpty()) return false;
        return true;
    }

    public Symbol getSymbolAt(int row, int col) {
        return grid[row][col].getSymbol();
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol symbol = grid[i][j].getSymbol();
                System.out.print(symbol == Symbol.EMPTY ? "_" : symbol);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean hasWinner(Symbol symbol) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j].getSymbol() != symbol) rowWin = false;
                if (grid[j][i].getSymbol() != symbol) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        // Check diagonals
        boolean mainDiag = true, antiDiag = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i].getSymbol() != symbol) mainDiag = false;
            if (grid[i][size - i - 1].getSymbol() != symbol) antiDiag = false;
        }

        return mainDiag || antiDiag;
    }

    protected void makeMove(int i, int j, Symbol symbol) {
        lastSymbol = grid[i][j].getSymbol();
        setSymbolAt(i,j, symbol);
    }

    protected void undoMove(int i, int j) {
        setSymbolAt(i,j, lastSymbol);
    }
}