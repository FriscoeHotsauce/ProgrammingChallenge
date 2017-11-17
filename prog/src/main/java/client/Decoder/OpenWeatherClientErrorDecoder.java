package client.Decoder;

import exception.CityNotFoundException;
import exception.InvalidApiKeyException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static feign.FeignException.errorStatus;

public class OpenWeatherClientErrorDecoder implements ErrorDecoder {

    /**
     * A custom decoder for feign; if our rest call results in a 404, according to the OpenWeather API this means the city is not found. Throw a custom exception as a result.
     *
     * @return CityNotFoundException
     */
    public Exception decode(String methodKey, Response response){
        if(response.status() == 404){
            return new CityNotFoundException();
        }

        if(response.status() == 401){
            return new InvalidApiKeyException();
        }

        return errorStatus(methodKey, response);
    }

}
