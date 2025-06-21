package LoggerFramework;

public class Client {
    public static void main(String[] args) {
        LogManager manager = LogManager.getInstance();
        // Configure
        manager.setCurrentLogLevel(LogLevel.INFO);
        manager.addAppender(new ConsoleAppender());
        manager.addAppender(new FileAppender("app.log"));

        // Use logger
        Logger logger = new Logger();

        logger.debug("This is a DEBUG message. (Should not appear if level is INFO)");
        logger.info("This is an INFO message.");
        logger.warning("This is a WARN message.");
        logger.error("This is an ERROR message.");
        logger.fatal("This is a FATAL message.");
    }
}