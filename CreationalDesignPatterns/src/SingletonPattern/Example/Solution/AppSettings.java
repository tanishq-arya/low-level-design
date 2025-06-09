package SingletonPattern.Example.Solution;

public class AppSettings {
    // Step 1: Private static instance of the class
    private static AppSettings instance = null;

    private final String databaseUrl;
    private final String apiKey;

    // Step 2: Private constructor to prevent direct object creation
    private AppSettings() {
        // Read settings from a config file
        databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        apiKey = "12345-ABCDE";
    }

    // Step 3: Public static method to get the single instance of the class
    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    // Step 4: Can't clone the instance object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }
}