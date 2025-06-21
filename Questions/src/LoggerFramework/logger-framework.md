```text
+----------------+
|   LogLevel     |   <<Enum>>
+----------------+
| DEBUG          |
| INFO           |
| WARNING        |
| ERROR          |
| FATAL          |
+----------------+

          |
          |  (used in)
          v

+----------------+
|  LogMessage    |
+----------------+
| - timestamp    |
| - level: LogLevel |
| - message: String |
+----------------+

          |
          |  (created by)
          v

+----------------+
|   Logger       |
+----------------+
| - logManager: LogManager |
+----------------+
| + log(level, msg) |
| + debug(msg)      |
| + info(msg)       |
| + warning(msg)    |
| + error(msg)      |
| + fatal(msg)      |
+----------------+

          |
          |  (delegates to)
          v

+----------------+
|  LogManager    | <<Singleton>>
+----------------+
| - logLevel: LogLevel  |
| - appenders: List<Appender> |
+----------------+
| + getInstance() |
| + log(LogMessage) |
| + addAppender(Appender) |
| + setLogLevel(LogLevel) |
+----------------+

          |
          |  (calls)
          v

+----------------+
| <<Interface>>  |
|   Appender     |
+----------------+
| + append(LogMessage) |
+----------------+

          |
          |  (implements)
  ------------------------------
  |             |               |
  v             v               v
+----------------+  +----------------+  +----------------+
| ConsoleAppender|  |  FileAppender  |  | DatabaseAppender |
+----------------+  +----------------+  +----------------+
| + append()     |  | + append()     |  | + append()      |
+----------------+  +----------------+  +----------------+

```