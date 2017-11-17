package application;

import dto.WeatherMainDto;
import exception.CityNotFoundException;
import exception.InvalidApiKeyException;
import service.PropertyService;
import service.WeatherService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        //Create our services. In a web framework, we would likely use some form of dependency injection instead.
        PropertyService props = new PropertyService();
        WeatherService service = new WeatherService(props);

        //Prompt the user for input
        Scanner reader = new Scanner(System.in);
        System.out.println("Where are you from?: ");
        String location = reader.next();
        WeatherMainDto weatherInfo;
        //Attempt to fetch the data through the web service, catching our CityNotFound exception thrown by feign.
        try{
            weatherInfo = service.getMainWeatherData(location);
        } catch (CityNotFoundException e){
            System.out.println("City not found!");
            return;
        } catch (InvalidApiKeyException ex){
            System.out.println("Api key invalid!");
            return;
        }

        //If we've not encountered an error, proceed to informing our user about the temperature in their area.
        System.out.printf("The current temperature in " + location+ " is %.2f degrees fahrenheit.\n", weatherInfo.getTemp());
        System.out.printf("Local temperatures may vary from %.2f to %.2f degrees.\n", weatherInfo.getHighTemp(), weatherInfo.getLowTemp());
        System.out.printf("Humidity: %d%%.\n", weatherInfo.getHumidity());

        reader.close();
    }
}
