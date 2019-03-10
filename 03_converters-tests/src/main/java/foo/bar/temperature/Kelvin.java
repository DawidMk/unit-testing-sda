package foo.bar.temperature;

import java.math.BigDecimal;

public class Kelvin implements TemperUnit {
    private final BigDecimal value;

    public Kelvin(BigDecimal value) {
        this.value = value;
    }
}
