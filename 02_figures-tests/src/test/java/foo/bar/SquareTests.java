package foo.bar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTests {

    @ParameterizedTest(name = "Area of square({0}) should be {1}")
    @CsvSource({
                 "0, 0",
                 "1, 1",
                 "10, 100"
    })
    void areaOfSquare(int a, int expectedArea) {
        Square square = new Square(a);
        assertEquals(expectedArea, square.area(), "Area of square is different than expected");
    }

    @ParameterizedTest(name = "Circumference of square with sides ({0}) should be {1}")
    @CsvSource({
            "0, 0",
            "1, 4",
            "10, 40"
    })
    void circumferenceOfSquare(int a, int expectedArea) {
        Square square = new Square(a);
        assertEquals(expectedArea, square.circumference(), "Area of square is different than expected");
    }
}
