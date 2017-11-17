package main;

import service.PropertyService;
import service.WeatherService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){

        PropertyService props = new PropertyService();
        WeatherService service = new WeatherService(props);

        Scanner reader = new Scanner(System.in);
        System.out.println("Where are you from?: ");
        String location = reader.next();
        System.out.println("The current temperature in " + location + " is X degrees");
        System.out.println("Api key: "+ props.getApiKey());

        reader.close();

    }
}
