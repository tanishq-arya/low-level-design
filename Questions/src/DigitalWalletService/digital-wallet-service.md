```text
                         +-------------------------------------------+
                         |         WalletService                     |  <<Facade>>
                         +-------------------------------------------+
                         | + createWallet(userId, curr):Wallet       |
                         | + addPaymentMethod(walletId, pm):void     |
                         | + transfer(fromId,toId,amt):Transaction   |
                         | + getStatement(walletId):List<Transaction>|
                         +---------------+---------------------------+
                                         |
             +---------------------------+---------------------------+
             |                           |                           |
             v                           v                           v
+-------------------------+  +---------------------------+   +-------------------------------+
|     WalletManager       |  |  TransactionManager       |   | CurrencyConversionService     |
+-------------------------+  +---------------------------+   +-------------------------------+
| + create(user,curr):W   |  | + record(t):void          |   | + convert(from,to,amt):double |
| + deposit(w,amt):void   |  | + list(walletId):List<T>  |   +-------------------------------+
| + withdraw(w,amt):void  |  | + updateStatus(id,s):void |
+-------------------------+  +---------------------------+
             |                           |
             v                           v
+-----------------------+       +-----------------------+
|       Wallet          |       |     Transaction       |
+-----------------------+       +-----------------------+
| - id: String          |       | - id: String          |
| - owner: User         |       | - fromWallet: Wallet  |
| - currency: Currency  |       | - toWallet: Wallet    |
| - balance: double     |       | - amount: double      |
| - status: WalletStatus|       | - currency: Currency  |
+-----------------------+       | - timestamp: Date     |
                                | - status: TransactionStatus |
                                +-----------------------+

             ^
             |
             |  
+--------------------------+        +--------------------------------+
| PaymentMethodManager     |        |        PaymentMethod           |  <<Strategy>>
+--------------------------+        +--------------------------------+
| + add(pm):void           |        | + charge(amount):boolean       |
| + remove(id):void        |        | + refund(amount):boolean       |
| + list(walletId):List<PM>|        +--------------------------------+
+--------------------------+ 
                                                     ^
                                                     |
                                              +-------------+
                                              | CreditCard  |
                                              +-------------+
                                              | extends PM  |
                                              +-------------+
                                              | - cardNum   |
                                              +-------------+


```