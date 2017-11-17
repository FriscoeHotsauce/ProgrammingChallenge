package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {

    private String apiKey;

    public PropertyService(){
        loadProperties();
    }

    public String getApiKey(){
        return apiKey;
    }

    private void loadProperties(){
        Properties properties = new Properties();
        InputStream input = null;

        try{
            input = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            if(input == null){
                System.out.println("Unable to find properties file!");
                return;
            }
            properties.load(input);
            apiKey = properties.getProperty("apikey");

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(input != null){
                try{
                    input.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }

        }
    }

}
