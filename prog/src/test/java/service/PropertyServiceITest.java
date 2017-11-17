package service;

import org.junit.Test;

public class PropertyServiceITest {

    /**
     * Use this test to verify that the API key is set.
     */
    @Test
    public void loadProperties(){

        PropertyService propertyService = new PropertyService();
        System.out.println("api key: " + propertyService.getApiKey());

    }
}
