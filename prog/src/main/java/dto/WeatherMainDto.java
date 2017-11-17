package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import service.WeatherService;

/**
 *  A nested class with Jackson JSON Properties for decoding. We ignore unknown properties.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMainDto {

    private float temp;
    private int pressure;
    private int humidity;
    private float highTemp;
    private float lowTemp;

    @JsonProperty("temp")
    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = WeatherService.kelvinToFahrenheit(temp);
    }

    @JsonProperty("pressure")
    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temp_max")
    public float getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(float highTemp) {
        this.highTemp = WeatherService.kelvinToFahrenheit(highTemp);
    }

    @JsonProperty("temp_min")
    public float getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(float lowTemp) {
        this.lowTemp = WeatherService.kelvinToFahrenheit(lowTemp);
    }

    @Override
    public String toString() {
        return "WeatherMainDto{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", highTemp=" + highTemp +
                ", lowTemp=" + lowTemp +
                '}';
    }
}
