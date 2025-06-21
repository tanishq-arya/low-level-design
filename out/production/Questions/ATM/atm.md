## ATM 
```text
             +-------------------+
             |       ATM         |  ← context, holds states + shared resources
             +-------------------+
             | - idleState       |
             | - hasCardState    |
             | - authenticated   |
             | - transactionState|
             | - dispenseState   |
             | - ejectState      |
             | - currentState    |
             | - accounts, cash  |
             +-------------------+
             | + insertCard()    |
             | + enterPIN()      |
             | + selectAction()  |
             | + deposit()       |
             | + withdraw()      |
             | + ejectCard()     |
             +--------|----------+
                      |
          delegates to |  (currentState.insertCard(), etc.)
                      v
             +-----------------+
             | <<interface>>   |
             | ATMState        |
             +-----------------+
             | + insertCard()  |
             | + enterPIN()    |
             | + selectAction()|
             | + deposit()     |
             | + withdraw()    |
             | + ejectCard()   |
             +-----------------+
          /      |         \          ...  
         /       |          \
        v        v           v
 IdleState  HasCardState  AuthenticatedState  ...

```

```text
                 +----------------------+
                 |   CashDispenser      |  <<interface>>
                 +----------------------+
                 | + setNext(next)      |
                 | + dispense(amount)   |
                 +----------------------+
                          ^
                          |
         +----------------+----------------+----------------+----------------+-------------------------+
         |                                 |                                 |                         |
+-----------------------+     +-----------------------+     +-----------------------+     +-----------------------+
|  Dollar100Dispenser   |     |   Dollar50Dispenser   |     |   Dollar20Dispenser   |     |   Dollar10Dispenser   |
+-----------------------+     +-----------------------+     +-----------------------+     +-----------------------+
| - next: CashDispenser |     | - next: CashDispenser |     | - next: CashDispenser |     | - next: CashDispenser |
+-----------------------+     +-----------------------+     +-----------------------+     +-----------------------+
| + setNext(next)       |     | + setNext(next)       |     | + setNext(next)       |     | + setNext(next)       |
| + dispense(amount)    |     | + dispense(amount)    |     | + dispense(amount)    |     | + dispense(amount)    |
+-----------------------+     +-----------------------+     +-----------------------+     +-----------------------+

```