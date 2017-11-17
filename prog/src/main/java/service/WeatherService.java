package service;

import client.Decoder.OpenWeatherClientErrorDecoder;
import client.OpenWeatherClient;
import dto.WeatherMainDto;
import exception.CityNotFoundException;
import exception.InvalidApiKeyException;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class WeatherService {

    private OpenWeatherClient weatherClient;
    private PropertyService propertyService;

    public WeatherService(PropertyService propertyService){
        this.propertyService = propertyService;
        this.weatherClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new OpenWeatherClientErrorDecoder())
                .target(OpenWeatherClient.class, "https://api.openweathermap.org");
    }

    public WeatherMainDto getMainWeatherData(String location) throws CityNotFoundException, InvalidApiKeyException{
        return weatherClient.getWeatherAtLocation(location, propertyService.getApiKey()).getMain();
    }

    public static float kelvinToFahrenheit(float kelvin){
        return ((9/5) * (kelvin - 273) + 32);
    }
}
