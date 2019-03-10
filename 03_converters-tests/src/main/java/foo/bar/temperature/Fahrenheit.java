package foo.bar.temperature;

import java.math.BigDecimal;

public class Fahrenheit implements TemperUnit {

    private final BigDecimal value;

    public Fahrenheit(BigDecimal value) {
        this.value = value;
    }


}
