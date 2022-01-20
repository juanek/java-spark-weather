package ar.com.juanek;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        WeatherServices weatherServices = new WeatherServices();
        String entity = weatherServices.getWeather("London");
        System.out.println(entity);

        assertTrue( true );
    }
}
