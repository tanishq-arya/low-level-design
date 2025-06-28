```text
                                    +-------------------------------+
                                    |         PubSubService         |
                                    +-------------------------------+
                                    | - topics: Map<String, Topic>  |
                                    | - dispatcher: Dispatcher      |
                                    +-------------------------------+
                                    | + publish(name, msg): void    |
                                    | + subscribe(name, sub): void  |
                                    | + unsubscribe(name, sub): void|
                                    +-------------------------------+
                                               |
                               depends on      | uses
                                               v
                                    +-------------------------------+
                                    |            Topic              |
                                    +-------------------------------+
                                    | - name: String                |
                                    | - subscribers: Set<Subscriber>|
                                    +-------------------------------+
                                    | + addSubscriber(sub): void    |
                                    | + removeSubscriber(sub): void |
                                    | + getSubscribers(): Set<Subscriber> |
                                    +-------------------------------+
                                               |
                              aggregates       | holds
                                               v
                                +-----------------------------+
                                |         Subscriber          |
                                +-----------------------------+
                                | <<interface>>               |
                                | + onMessage(msg: Message)   |
                                +-----------------------------+
                                               ^
                                               | processes
                                               |
                                    +-------------------------------+
                                    |         Dispatcher            |
                                    +-------------------------------+
                                    | - executor: ExecutorService   |
                                    +-------------------------------+
                                    | + dispatch(topic, msg): void  |
                                    +-------------------------------+
                                               |
                                               | delivers to
                                               v
                                +-----------------------------+
                                |          Message            |
                                +-----------------------------+
                                | - content: String           |
                                | - timestamp: Date           |
                                +-----------------------------+
                                | + getContent(): String      |
                                | + getTimestamp(): Date      |
                                +-----------------------------+
```