package LoggerFramework;

public class ConsoleAppender implements Appender{
    @Override
    public void append(LogLevel level, String timestamp, String message) {
        System.out.println("Console: [" + timestamp + "] [" + level + "] " + message);
    }
}