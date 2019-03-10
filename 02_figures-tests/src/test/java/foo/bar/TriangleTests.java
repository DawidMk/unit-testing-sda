package foo.bar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTests {

    @ParameterizedTest(name = "Area of triangle({0}) should be {1}")
    @CsvFileSource(resources = "/triangle_area.csv", numLinesToSkip = 1)
//    @CsvSource({
//            "4, 2, 4",
//            "0, 0, 0",
//            "10, 4, 20"
//    })
    void areaOfTriangle(int a, int h, int expectedArea) {
        Triangle triangle = new Triangle(a, h);
        assertEquals(expectedArea, triangle.area(), "Area of square is different than expected");
    }

    @ParameterizedTest(name = "Circumference of square with sides ({0}) should be {1}")
    @CsvSource({
            "3, 9",
            "1, 3",
            "10, 30"
    })
    void circumferenceOfSquare(int a, int expectedArea) {
        Triangle triangle = new Triangle(a);
        assertEquals(expectedArea, triangle.circumference(), "circumference of triangle is different than expected");
    }
}
