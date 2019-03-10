package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherAlarmNotifierTest {

    private WeatherAlarmNotifier alarmNotifier =
            new WeatherAlarmNotifier(
                    new WeatherService(
                            new TemperatureProvider(),
                            new RainfallProvider(),
                            new WindSpeedProvider()
                    )
            );
    WeatherService weatherServiceMock = mock(WeatherService.class);

    @ParameterizedTest(name = "temp: {0}, wind {1}, rain {2}")
    @CsvSource({
            "710, 20, 30",
            "36, 56, 78",
            "44, 12, 66"

    })
    void tempTooHighAlarm(int temp, int wind, int rain) {
        when(weatherServiceMock.getWeather()).thenReturn(new Weather(temp, wind, rain));
//        when(windMock.getWindSpeed()).thenReturn(10);
        alarmNotifier = new WeatherAlarmNotifier(weatherServiceMock);

        assertEquals(WeatherAlarmLevel.SECOND_LEVEL, alarmNotifier.raiseLevelIfNeccessary());

    }
    @ParameterizedTest(name = "temp: {0}, wind {1}, rain {2}")
    @CsvSource({
            "7, 20, 300",
            "3, 56, 708",
            "4, 12, 606"

    })
    void rainTooHigh(int temp, int wind, int rain) {
        when(weatherServiceMock.getWeather()).thenReturn(new Weather(temp, wind, rain));
        alarmNotifier = new WeatherAlarmNotifier(weatherServiceMock);
        assertEquals(WeatherAlarmLevel.THIRD_LEVEL, alarmNotifier.raiseLevelIfNeccessary());

    }

}
