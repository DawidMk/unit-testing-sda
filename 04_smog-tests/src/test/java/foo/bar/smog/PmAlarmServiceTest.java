package foo.bar.smog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PmAlarmServiceTest {
    private static PmAlarmService pmAlarmService;
    private static long startTime;
    private static long endTime;

    @BeforeAll
    static void timeStart() {
        startTime = System.currentTimeMillis();
    }

    @BeforeEach
    public void alarmSetup() {
        pmAlarmService = new PmAlarmService();
    }

    @AfterAll
    static void timeExecution() {
        endTime = System.currentTimeMillis();
        Logger.getLogger("JUnit 5").info("elapsed time: " + (endTime - startTime));
    }

    @Test
    void shouldReturnNoneForMeasurement_10() {
//        PmAlarmService service = new PmAlarmService();
//        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(10, Country.POLAND));
        assertEquals(AlarmLevel.NONE, pmAlarmService.getAlarmMessage(10, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_201() {
//        PmAlarmService service = new PmAlarmService();
//        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(201, Country.POLAND));
        assertEquals(AlarmLevel.INFO, pmAlarmService.getAlarmMessage(201, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_350() {
//        PmAlarmService service = new PmAlarmService();
//        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(301, Country.POLAND));
        assertEquals(AlarmLevel.WARNING, pmAlarmService.getAlarmMessage(301, Country.POLAND));
    }

    //    @Test
    @ParameterizedTest(name = "measure {0}, country {1}, level {2}")

    @CsvSource({
            "301, POLAND, WARNING",
            "49, FINLAND, NONE",
            "55, FRANCE, INFO"
    })
    void shouldReturnInfoFor_51(int measure, Country country, AlarmLevel expectedLevel) {
        assertEquals(expectedLevel, pmAlarmService.getAlarmMessage(measure, country));

    }
}
