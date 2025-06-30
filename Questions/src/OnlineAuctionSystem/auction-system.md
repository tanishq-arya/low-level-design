```text
                   +--------------------------------+
                   |         AuctionSystem         |  <<Facade>>
                   +--------------------------------+
                   | + register(username,pwd):User |
                   | + login(email,pwd):Token      |
                   | + createAuction(token,        |
                   |     title,desc,tags,          |
                   |     startPrice,start,end):    |
                   |       AuctionItem             |
                   | + searchAuctions(token,       |
                   |     criteria):List<AuctionItem>|
                   | + placeBid(token,auctionId,   |
                   |     amount):Bid               |
                   | + closeAuction(token,auctionId)|
                   |     :void                     |
                   +--------------------------------+
                                /       |       \
                               /        |        \
                              v         v         v
             +----------------------+ +-----------------------+ +------------------------+
             |     UserService      | |    AuctionService     | | NotificationService    |
             +----------------------+ +-----------------------+ +------------------------+
             | + register(...)      | | + createAuction(...)  | | + subscribe(listener)  |
             | + login(...)         | | + search(...)         | | + notifyOutbid(bid)    |
             | + getUser(id):User   | | + placeBid(...)       | | + notifyClosed(item)   |
             +----------------------+ | + closeAuction(...)   | +------------------------+
                                       +-----------------------+
                                                |
                                                v
                   +---------------------------------------------+
                   |                AuctionItem                  |
                   +---------------------------------------------+
                   | - id: String                                |
                   | - title: String                             |
                   | - description: String                       |
                   | - tags: Set<String>                         |
                   | - startPrice: double                        |
                   | - minBidIncrement: double                   |
                   | - startTime: Date                           |
                   | - endTime: Date                             |
                   | - status: AuctionStatus                     |
                   | - currentHighestBid: Bid                    |
                   +---------------------------------------------+
                   | + addBid(b:Bid): void                       |
                   | + close(): void                             |
                   +---------------------------------------------+
                     ^                                  ^
                     | publishes events                 | aggregates
                     |                                  |
          +----------------------+        +-----------------------+
          |         Bid          |        |         User          |
          +----------------------+        +-----------------------+
          | - id: String         |        | - id: String          |
          | - amount: double     |        | - name: String        |
          | - bidder: User       |        | - email: String       |
          | - timestamp: Date    |        | - pwdHash: String     |
          +----------------------+        +-----------------------+
          | + getAmount():double |        | + notify(n:Notification):void |
          +----------------------+        +-----------------------+
                     ^                                  ^
                     | implements                       | holds
                     |                                  |
          +------------------------------+    +--------------------------+
          |  NotificationListener       |    |     Notification          |
          +------------------------------+    +--------------------------+
          | + onOutbid(item,Bid):void    |    | - id: String             |
          | + onAuctionClosed(item):void |    | - message: String        |
          +------------------------------+    | - timestamp: Date        |
                                              | - read: boolean          |
                                              +--------------------------+
                                              | + markRead(): void       |
                                              +--------------------------+

```