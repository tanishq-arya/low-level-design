```text
    +--------------------------------------+
    |              User                    |
    +--------------------------------------+
    | - id: String                         |
    | - name: String                       |
    | - email: String                      |
    +--------------------------------------+

                   1
                   |
                   | assigns / is assigned
                   *
    +--------------------------------------+
    |              Task                    |
    +--------------------------------------+
    | - id: String                         |
    | - title: String                      |
    | - description: String                |
    | - dueDate: Date                      |
    | - priority: TaskPriority             |
    | - status: TaskStatus                 |
    | - assignee: User                     |
    | - comments: List<Comment>            |
    | - history: List<String>              |  ← e.g. “2025-06-23: status TODO”
    | - reminders: List<Reminder>          |
    +--------------------------------------+
    | + updateStatus(s:Status): void       |
    | + updatePriority(p:Priority): void   |
    | + assignUser(u:User): void           |
    | + addComment(c:Comment): void        |
    | + addHistory(entry:String): void     |
    | + addReminder(r:Reminder): void      |
    +--------------------------------------+

                   *
                   |
                   1
    +--------------------------------------+
    |             Comment                  |
    +--------------------------------------+
    | - id: String                         |
    | - content: String                    |
    | - author: User                       |
    | - timestamp: Date                    |
    +--------------------------------------+

                   *
                   |
                   1
    +--------------------------------------+
    |             Reminder                 |
    +--------------------------------------+
    | - id: String                         |
    | - remindAt: Date                     |
    | - sent: boolean                      |
    +--------------------------------------+

    +--------------------------------------+
    |           TaskManager                |
    +--------------------------------------+
    | - tasks: Map<String, Task>           |
    | - currentUser: User                  |  ← for role checks
    +--------------------------------------+
    | + createTask(t:Task): void           |
    | + updateTaskStatus(id, s): void      |
    | + updateTaskPriority(id, p): void    |
    | + assignTask(id, u): void            |
    | + addComment(id, c): void            |
    | + addReminder(id, r): void           |
    | + listTasks(): List<Task>            |
    | + listByStatus(s): List<Task>        |
    | + listByAssignee(u): List<Task>      |
    | + deleteTask(id): void               |
    +--------------------------------------+

    <<enumerations>>
    + TaskStatus { TODO, IN_PROGRESS, DONE }
    + TaskPriority { LOW, MEDIUM, HIGH }
```