import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        String expression = "5+3";
        double expected = 8.0;
        double actual = calculator.evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        String expression = "10-4";
        double expected = 6.0;
        double actual = calculator.evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        String expression = "3*4";
        double expected = 12.0;
        double actual = calculator.evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void testComplexExpression() {
        Calculator calculator = new Calculator();
        String expression = "10+3*2-5";
        double expected = 11.0;
        double actual = calculator.evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidExpression() {
        Calculator calculator = new Calculator();
        String expression = "10+3*2$-5";
        try {
            calculator.evaluate(expression);
            // If no exception is thrown, the test should fail
            fail();
        } catch (IllegalArgumentException e) {
            // Expecting IllegalArgumentException for invalid character
            assertEquals("Invalid character in expression: $", e.getMessage());
        }
    }
}
