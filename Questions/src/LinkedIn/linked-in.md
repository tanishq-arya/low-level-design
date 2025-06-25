```text
+-------------+    +-------------+    +-------------+    +--------------+    +---------------+    +-------------------+
|    User     |    |   Company   |    | Connection  |    |    JobPost   |    |    Message    |    |    Notification   |
+-------------+    +-------------+    +-------------+    +--------------+    +---------------+    +-------------------+
| id          |    | id          |    | id          |    | id           |    | id            |    | id                |
| name        |    | name        |    | fromUser    |    | title        |    | fromUser      |    | recipient         |
| email       |    | industry    |    | toUser      |    | description  |    | toUser        |    | type              |
| profile     |    | description |    | status      |    | postedAt     |    | content       |    | payload           |
+-------------+    +-------------+    +-------------+    +--------------+    +---------------+    +-------------------+

      |                   |                  |                    |                    |                    |
      v                   v                  v                    v                    v                    v

+-------------------------+    +------------------------+    +-------------------------+
|      UserManager        |    |  ConnectionManager     |    |       JobManager        |
+-------------------------+    +------------------------+    +-------------------------+
| + createUser(...)       |    | + sendRequest(...)     |    | + postJob(...)          |
| + updateProfile(...)    |    | + respondRequest(...)  |    | + listJobs(...)         |
| + getUsers()            |    | + listConnections(...) |    | + listCompanyJobs(...)  |
+-------------------------+    +------------------------+    +-------------------------+

      |                                                         |
      |                                                         |
      v                                                         v

+-------------------------+                       +-------------------------+
|   MessagingService      |                       |  NotificationService     |
+-------------------------+                       +-------------------------+
| + sendMessage(...)      |                       | + registerListener(...) |
| + fetchConversation(...)|                       | + notify(event...)      |
+-------------------------+                       +-------------------------+

                         ^                                  
                         |                                   
                   delegates to                            
                         |                                   
                         v                                   

              +---------------------------------------+
              |  LinkedInService (Facade)             |
              +---------------------------------------+
              | - auth: AuthService                   |
              | - userMgr: UserManager                |
              | - connMgr: ConnectionManager          |
              | - jobMgr: JobManager                  |
              | - msgSvc: MessagingService            |
              | - notifSvc: NotificationService       |
              +---------------------------------------+
              | + register(...)                       |
              | + login(...)                          |
              | + createProfile(...)                  |
              | + sendConnectionRequest(...)          |
              | + postJob(...)                        |
              | + sendMessage(...)                    |
              | + getNotifications(...)               |
              +---------------------------------------+

                         |                                   
                         | uses                              
                         v                                   

              +-------------------------------------+
              |  AuthService (Singleton)            |
              +-------------------------------------+
              | - users: Map<email,User>            |
              | - sessions: Map<token,Session>      |
              +-------------------------------------+
              | + register(...) : User              |
              | + login(...)    : String (token)    |
              | + validate(token) : Session         |
              | + logout(token) : void              |
              +-------------------------------------+

```