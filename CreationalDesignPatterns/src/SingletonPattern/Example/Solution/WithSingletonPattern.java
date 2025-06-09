package SingletonPattern.Example.Solution;

public class WithSingletonPattern {

    public static void main(String[] args) {
        AppSettings appSettings = AppSettings.getInstance();
        AppSettings appSettingsCopy = AppSettings.getInstance();

        System.out.println("appSettings apiKey: " + appSettings.getApiKey());
        System.out.println("appSettingsCopy apiKey: " + appSettingsCopy.getApiKey());

        // Now these 2 are the same instance
        System.out.println(appSettings == appSettingsCopy);
    }
}