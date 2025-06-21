package LoggerFramework;

import java.util.ArrayList;
import java.util.List;

// Singleton object
public class LogManager {
    private static LogManager instance; // 1. instance

    // variables / resources / config
    private LogLevel currentLogLevel;
    private final List<Appender> appenders;

    // 2. private constructor
    private LogManager() {
        this.currentLogLevel = LogLevel.DEBUG; // default
        this.appenders = new ArrayList<>();
    }

    // 3. public getInstance method
    public static synchronized LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    // Setters and getters
    public void setCurrentLogLevel(LogLevel currentLogLevel) {
        this.currentLogLevel = currentLogLevel;
    }

    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    public LogLevel getCurrentLogLevel() {
        return currentLogLevel;
    }

    public List<Appender> getAppenders() {
        return appenders;
    }
}