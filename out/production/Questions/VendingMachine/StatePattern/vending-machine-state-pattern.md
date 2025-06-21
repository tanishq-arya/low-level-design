```text
                    +-----------------+
                    | VendingMachine  |  ←─ holds references to all States
                    +-----------------+
                    | - idleState: IdleState
                    | - readyState: ReadyState
                    | - dispenseState: DispenseState
                    | - returnChangeState: ReturnChangeState
                    | - currentState: VendingMachineState
                    | - inventory, totalPayment, selectedProduct
                    +-----------------+
                    | + selectProduct(p)
                    | + insertCoin(c)
                    | + dispenseProduct()
                    | + returnChange()
                    +-----------------+
                              |
                 delegates to  |  (calls currentState.selectProduct(...) etc.)
                              v
                    +----------------------------+
                    | <<interface>>              |
                    | VendingMachineState        |
                    +----------------------------+
                    | + selectProduct(Product)   |
                    | + insertCoin(Coin)         |
                    | + insertNote(Note)         |
                    | + dispenseProduct()        |
                    | + returnChange()           |
                    +----------------------------+
                    /         |          |          \
                   /          |          |           \
                  v           v          v            v
         +--------------+ +--------------+ +-------------+ +-----------------+
         | IdleState    | | ReadyState   | | Dispense... | | ReturnChange... |
         +--------------+ +--------------+ +-------------+ +-----------------+
         | selectProd → | | insertCoin → | | dispense →  | | returnChange →  |
         |  setState()  | |  checkPayment| | deductProd  | | reset & idle    |
         +--------------+ +--------------+ +-------------+ +-----------------+
```