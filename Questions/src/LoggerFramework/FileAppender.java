package LoggerFramework;

public class FileAppender implements Appender{
    private final String filename;

    FileAppender(String filename) {
        this.filename = filename;
    }

    @Override
    public void append(LogLevel level, String timestamp, String message) {
        System.out.println("File(" + filename + "): [" + timestamp + "] [" + level + "] " + message);
    }
}