import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "Addition failed");
        assertEquals(-1, calculator.add(-3, 2), "Addition with negatives failed");
        assertEquals(0, calculator.add(0, 0), "Addition with zeros failed");
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "Subtraction failed");
        assertEquals(-5, calculator.subtract(-3, 2), "Subtraction with negatives failed");
        assertEquals(0, calculator.subtract(0, 0), "Subtraction with zeros failed");
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "Multiplication failed");
        assertEquals(-6, calculator.multiply(-3, 2), "Multiplication with negatives failed");
        assertEquals(0, calculator.multiply(0, 2), "Multiplication with zero failed");
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "Division failed");
        assertEquals(-2, calculator.divide(-6, 3), "Division with negatives failed");
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0), "Division by zero should throw exception");
    }
}
