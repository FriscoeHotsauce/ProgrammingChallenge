package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A parent class for all of the information that the OpenWeather api sends us. We only care about the "main" section,
 * as that is where the temperature is; therefore we ignore unknown properties.
 *
 * A side note, in order for jackson to deserialize correctly we must mimic the structure of the JSON object we receive
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    private WeatherMainDto main;
    private float temp;

    @JsonProperty("main")
    public WeatherMainDto getMain() {
        return main;
    }

    public void setMain(WeatherMainDto main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "main=" + main +
                '}';
    }
}
