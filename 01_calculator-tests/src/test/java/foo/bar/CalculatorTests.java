package foo.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("0 + 101 = 101")
    void addsTwoNumbers101() {
        Calculator calculator = new Calculator();
        assertEquals(101, calculator.add(0, 101), "0 + 101 should equal 101");
    }

    @Test
    @DisplayName("-5 + -2 = -7")
    void addsTwoNumbersMinuses() {
        Calculator calculator = new Calculator();
        assertEquals(-7, calculator.add(-5, -2), "-5 + -2 should equal -7");
    }


    @Test
    @DisplayName("2 - 2 = 0")
    void substractTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.substract(2, 2), "2 - 2 should equal 0");
    }

    @Test
    @DisplayName("extract: 2 - 2 = 0")
    void extractTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.extract(2, 2), "2 - 2 should equal 0");
    }

    @Test
    @DisplayName("2 * 2 = 4")
    void multiplyTwoNums() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.multiply(2, 2), "2 * 2 should be 4");
    }

    @Test
    @DisplayName("4 / 2 = 2")
    void divideTwoNums() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(4, 2), "4 / 2 should be 2");
    }


    @Test
    @DisplayName("division by 0")
    void divideByZero() throws IllegalArgumentException {
        Calculator calculator = new Calculator();
        IllegalArgumentException illegalArgumentException =
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0));

//        Assertions.assertEquals(illegalArgumentException, );
    }
}


