package service;

import client.OpenWeatherClient;
import feign.Feign;

public class WeatherService {

    private OpenWeatherClient weatherClient;
    private PropertyService propertyService;

    public WeatherService(PropertyService propertyService){
        this.propertyService = propertyService;
        this.weatherClient = Feign.builder().target(OpenWeatherClient.class, "api.openweathermap.org");
    }

    public float getTemperatureByLocation(String location){
        return weatherClient.getWeatherAtLocation(location, propertyService.getApiKey()).getTemperature();
    }
}
