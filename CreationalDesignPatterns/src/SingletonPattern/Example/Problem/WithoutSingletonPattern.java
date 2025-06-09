package SingletonPattern.Example.Problem;

public class WithoutSingletonPattern {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();

        AppSettings appSettingsCopy = new AppSettings();

        // The api key is same here -> but can be modified by 1 object
        System.out.println(appSettings.getApiKey());
        System.out.println(appSettingsCopy.getApiKey());

        // These are 2 different objects -> more memory
        System.out.println(appSettings == appSettingsCopy);

        // Problem -> only 1 object should exist
    }
}