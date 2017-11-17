package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDto {

    private float temperature;

    @JsonProperty("temp")
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
