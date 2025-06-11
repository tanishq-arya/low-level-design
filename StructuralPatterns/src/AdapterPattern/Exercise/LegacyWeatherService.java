// The Legacy class that provides weather data in XML format.

package AdapterPattern.Exercise;

public class LegacyWeatherService implements WeatherService {
    
    private String temperature;
    private String condition;

    public LegacyWeatherService(String temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    @Override
    public String getWeatherData() {
        return "<weather><temperature>" + temperature + "</temperature><condition>" + condition + "</condition></weather>";
    }
}