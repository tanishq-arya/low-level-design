package LoggerFramework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Logger {
    private final LogManager manager;

    public Logger() {
        this.manager = LogManager.getInstance();
    }

    public void log(LogLevel level, String msg) {
        // Check if the level passed is above the set level -> only then log
        // Example - WARN is set > Logger.log(DEBUG,"test") > this should not print
        // As only WARN, ERROR, FATAL are allowed
        if (level.getLevel() >= manager.getCurrentLogLevel().getLevel()) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            List<Appender> appenders = manager.getAppenders();

            // Simply loop over and log to all outputs which are added
            for (Appender appender : appenders) {
                appender.append(level, timestamp, msg);
            }
        }
    }

    // Convenience methods
    // 1. Increase code readability.
    // 2. Increased efficiency.
    // 3. User-friendly.
    // 4. Reduced code > user doesn't need to pass any level
    public void debug(String msg) { log(LogLevel.DEBUG, msg); }
    public void info(String msg) { log(LogLevel.INFO, msg); }
    public void warning(String msg) { log(LogLevel.WARN, msg); }
    public void error(String msg) { log(LogLevel.ERROR, msg); }
    public void fatal(String msg) { log(LogLevel.FATAL, msg); }
}