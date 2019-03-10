package foo.bar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RhombusTest {

    @ParameterizedTest(name = "Area of rhombus({0}) should be {1}")
    @CsvSource({
            "0, 0, 0",
            "1, 1, 1",
            "10,2, 20"
    })
    void areaOfRhombus(int a, int h, int expectedArea) {
        Rhombus rhombus = new Rhombus(a, h);
        assertEquals(expectedArea, rhombus.area(), "Area of rh is different than expected");
    }

    @ParameterizedTest(name = "Circumference of rh with sides ({0}) should be {1}")
    @CsvSource({
            "0, 0",
            "1, 4",
            "10, 40"
    })
    void circumferenceOfSquare(int a, int expectedArea) {
        Rhombus rhombus = new Rhombus(a);
        assertEquals(expectedArea, rhombus.circumference(), "Area of rh is different than expected");
    }
}
