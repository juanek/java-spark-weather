package ar.com.juanek;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ServicesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WeatherServices.class).in(Singleton.class);
    }
}
