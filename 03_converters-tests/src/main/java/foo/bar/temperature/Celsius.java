package foo.bar.temperature;

import java.math.BigDecimal;

public class Celsius implements TemperUnit {

    public static final BigDecimal CELSIUS_TO_KELVIN =
            new BigDecimal("273.15").setScale(SCALE, ROUNDING_MODE);

//    public static final BigDecimal CELSIUS_TO_FAHR =
//            new BigDecimal("32.00").setScale(SCALE, ROUNDING_MODE);

    private final BigDecimal value;

    public Celsius(BigDecimal value) {
        if (BigDecimal.valueOf(-273.15).compareTo(value) > 0) {
            throw new IllegalArgumentException("can't be less than -273.15!");
        }
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Celsius toKelvin() {
        return new Celsius(value.add(CELSIUS_TO_KELVIN).setScale(SCALE, ROUNDING_MODE));
    }

    public Celsius toFahr() {
        return new Celsius((value.multiply(BigDecimal.valueOf(1.8))).add(BigDecimal.valueOf(32.00)).setScale(SCALE, ROUNDING_MODE));
    }
}
