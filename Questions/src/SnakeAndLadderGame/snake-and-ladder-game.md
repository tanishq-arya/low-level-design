```text
+----------------------------------------------------+
|                  GameManager                       |  <<facade to manage sessions>>
+----------------------------------------------------+
| - sessions: List<GameSession>                      |
+----------------------------------------------------+
| + createSession(players, boardConfig): GameSession |
| + getSession(id): GameSession                      |
+----------------------------------------------------+
                |  (manages)
                v
+----------------------------------------------------+
|                  GameSession                       |
+----------------------------------------------------+
| - id: String                                       |
| - board: Board                                     |
| - players: List<Player>                            |
| - currentPlayerIdx: int                            |
| - die: Die                                         |
+----------------------------------------------------+
| + start(): void                                    |
| + takeTurn(): void                                 |
| + isFinished(): boolean                            |
| + getWinner(): Player?                             |
+----------------------------------------------------+
        |          |               |
        |          |               |
        v          v               v
+--------+   +-----------+    +---------+
| Board  |   |   Player  |    |   Die   |
+--------+   +-----------+    +---------+
| - size       | - id         |          |
| - n           | - name       | + roll() |
| - jumps: Map<Integer,Integer> | - pos  | 
+--------+   +-----------+    +---------+

Legend:
- Board.jumps holds both snakes and ladders: key = start cell, value = destination cell.
- GameSession loops over players, rolls `Die`, moves them, applies snakes/ladders via Board, and checks for win (position ≥ size*size).

```