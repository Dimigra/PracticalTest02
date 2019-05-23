package ro.pub.cs.systems.eim.practicaltest02;

public class WeatherForecastInformation {

    private String temperature;
    private String windSpeed;
    private String condition;
    private String pressure;
    private String humidity;

    public WeatherForecastInformation() {
        this.temperature = null;
        this.windSpeed = null;
        this.condition = null;
        this.pressure = null;
        this.humidity = null;
    }

    public WeatherForecastInformation(String temperature) {
        this.temperature = temperature;
    }

    public String getData() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherForecastInformation{" +
                "temperature='" + temperature + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", condition='" + condition + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }

}