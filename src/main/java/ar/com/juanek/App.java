package ar.com.juanek;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;

/**
 * http://localhost:4567/weather/Santa Fe,AR
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
       public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ServicesModule());
        WeatherServices weatherServices = injector.getInstance(WeatherServices.class);

        get("/weather/:city", (req, res) -> {
            res.type("application/json");
            return weatherServices.getWeather(req.params(":city"));
        });

        get("/json/:name", (req, res) -> {
                    res.type("application/json");
                    return ImmutableMap.of("name", req.params(":name"));
                },
                new Gson()::toJson);
    }
}
