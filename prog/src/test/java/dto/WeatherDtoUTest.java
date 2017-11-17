package dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class WeatherDtoUTest {

    private static final String EXAMPLE_RESPONSE = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":802,\"application\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"application\":{\"temp\":280.87,\"pressure\":1027,\"humidity\":71,\"temp_min\":278.15,\"temp_max\":283.15},\"visibility\":10000,\"wind\":{\"speed\":2.6,\"deg\":350},\"clouds\":{\"all\":40},\"dt\":1510865400,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.1775,\"country\":\"GB\",\"sunrise\":1510816916,\"sunset\":1510848507},\"id\":2643743,\"name\":\"London\",\"cod\":200}";

    @Test
    public void deserializeWeather() throws IOException {

        //Use the jackson ObjectMapper to verify that we are deserializing a string correctly
        WeatherDto weatherDto = new ObjectMapper().readerFor(WeatherDto.class).readValue(EXAMPLE_RESPONSE);

        //verify that our temps are set correctly in fahrenheit during deserialization
        Assert.assertEquals(39.87f, weatherDto.getMain().getTemp(), 0.01f);
        Assert.assertEquals(1027, weatherDto.getMain().getPressure());
        Assert.assertEquals(71, weatherDto.getMain().getHumidity());
        Assert.assertEquals(37.15, weatherDto.getMain().getLowTemp(), 0.01f);
        Assert.assertEquals(42.15, weatherDto.getMain().getHighTemp(), 0.01f);
    }
}
