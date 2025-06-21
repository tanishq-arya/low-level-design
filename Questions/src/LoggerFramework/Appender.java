package LoggerFramework;

public interface Appender {
    void append(LogLevel level, String timestamp, String message);
}