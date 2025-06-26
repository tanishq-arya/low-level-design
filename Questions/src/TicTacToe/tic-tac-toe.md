```text
+-------------------+
|      Game         |
+-------------------+
| - board: Board    |       <>──────────────────────┐
| - players: List<Player>   <>──┐                   │
| - currPlayerIndex: int        │                   │
| - status: GameStatus          │                   │
+-------------------+           │                   │
| + startGame()     |           │                   │
| + makeMove(row, col)          │                   │
| + checkWinner()   |           │                   │
| + switchTurn()    |           │                   │
+-------------------+           │                   │
                                ▼                   ▼
                      +-------------------+       +-------------------+
                      |      Player       |       |      Board        |
                      +-------------------+       +-------------------+
                      | - name: String    |       | - size: int       |
                      | - symbol: Symbol  |       | - grid: Cell[][]  |
                      +-------------------+       +-------------------+
                                                  | + printBoard()    |
                                                  | + isFull()        |
                                                  | + placeSymbol()   |
                                                  +-------------------+
                                                         │
                                                         │  composition
                                                         ▼
                                                  +-------------------+
                                                  |      Cell         |
                                                  +-------------------+
                                                  | - row: int        |
                                                  | - col: int        |
                                                  | - symbol: Symbol  |
                                                  +-------------------+

+-------------------+       +-------------------+
|   enum Symbol     |       | enum GameStatus   |
+-------------------+       +-------------------+
| EMPTY, X, O       |       | IN_PROGRESS       |
+-------------------+       | DRAW              |
                            | WIN               |
                            +-------------------+

```