package SingletonPattern.Example.Problem;

public class AppSettings {
    private String databaseUrl;

    private String apiKey;

    public AppSettings() {
        // Read settings from a config file
        databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        apiKey = "12345-ABCDE";
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}