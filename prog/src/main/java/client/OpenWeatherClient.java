package client;

import dto.WeatherDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


@Headers({
    "Content-Type: application/json"
})
public interface OpenWeatherClient {

    /**
     *  Make a GET call to openweather and return the results
     *
     * @param location the location of the user
     * @param apiKey provided by program properties
     * @return a WeatherDto object, parsed by jackson
     */
    @RequestLine("GET /data/2.5/weather?q={location}&APPID={api_key}")
    WeatherDto getWeatherAtLocation(@Param("location") String location, @Param("api_key") String apiKey);

}
