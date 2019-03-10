package foo.bar.temperature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CelsiusTest {
    @Test
    void convertToFahrenheit(){
        Celsius celsius = new Celsius(BigDecimal.valueOf(1)).toFahr();
        Assertions.assertEquals(new BigDecimal("33.80"), celsius.getValue());
//                assertEquals(new BigDecimal("0.3938"), new Centimeter(BigDecimal.ONE).toInches().getValue());
    }

    @Test
    void convertToKelvin(){
        Celsius celsius = new Celsius(BigDecimal.valueOf(1)).toKelvin();
        Assertions.assertEquals(new BigDecimal("274.15"), celsius.getValue());
    }

    @Test
    void convertZero(){
        Celsius celsius = new Celsius(BigDecimal.ZERO).toFahr();
        Assertions.assertEquals(new BigDecimal("32.00"), celsius.getValue());
    }
}
