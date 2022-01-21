package ar.com.juanek;

import org.glassfish.jersey.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class WeatherServices {

    private static final Logger log = LoggerFactory.getLogger(WeatherServices.class);

    public String getWeather(String city) {
        Client client = ClientBuilder
                .newBuilder()
                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
                .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "WARNING")
                .build();


        String entity = client.target("https://api.openweathermap.org/data/2.5")
                .path("weather")
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", "dbd3b02d8958d62185d02e944cd5f522")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return entity;
    }

}
