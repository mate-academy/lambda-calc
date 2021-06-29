package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001d;
    private static Calculator testCalculator;

    @BeforeAll
    static void beforeAll() {
        testCalculator = new Calculator();
    }

    /**
     * Tests for method calculate()
     */
    @Test
    void calculate_LegalOperation_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_IllegalOperation_notOK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '?';
        assertThrows(IllegalStateException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for addition, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_Addition_MinusDoubleMax_VS_MinusDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_Zero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_DoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMax_VS_DoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  negative number
     */
    @Test
    void calculate_Addition_NegativeNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_NegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_Zero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_DoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_PositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_NegativeNumber_VS_DoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = -200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_Addition_MinusDoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_Zero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_DoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_MinusDoubleMin_VS_DoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  Zero
     */
    @Test
    void calculate_Addition_Zero_VS_MinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_NegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_MinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_Zero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_DoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_PositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_Zero_VS_DoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_Addition_DoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_Zero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0;
        char operation = '+';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_DoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMin_VS_DoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  positive number
     */
    @Test
    void calculate_Addition_PositiveNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = 200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_NegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = 200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_Zero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = 200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_DoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = 200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_PositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_PositiveNumber_VS_DoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = 200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter : MAX_VALUE
     */
    @Test
    void calculate_Addition_DoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_Zero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_DoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Addition_DoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for subtraction, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_Zero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_DoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for subtraction, first parameter :  negative number
     */
    @Test
    void calculate_Subtraction_NegativeNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = -200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_NegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = -200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_Zero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_DoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_PositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -200.0 - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_NegativeNumber_VS_DoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_Zero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_DoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_MinusDoubleMin_VS_DoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  Zero
     */
    @Test
    void calculate_Subtraction_Zero_VS_MinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_NegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_MinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_Zero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_DoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_PositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_Zero_VS_DoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_Subtraction_DoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_Zero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_DoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMin_VS_DoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  positive number
     */
    @Test
    void calculate_Subtraction_PositiveNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = 200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_NegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = 200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_Zero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = 200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_DoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = 200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_PositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_PositiveNumber_VS_DoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = 200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter : MAX_VALUE
     */
    @Test
    void calculate_Subtraction_DoubleMax_VS_MinusDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_Zero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_DoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_DoubleMax_VS_DoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_Division_MinusDoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_MinusDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_Zero_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_DoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = -Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMax_VS_DoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  negative number
     */
    @Test
    void calculate_Division_NegativeNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_NegativeNumber_VS_NegativeNumber_OK() {
        double firstArgument = -4.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_NegativeNumber_VS_MinusDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_NegativeNumber_VS_Zero_notOK() {
        double firstArgument = -2.0;
        double secondArgument = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_NegativeNumber_VS_DoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_NegativeNumber_VS_PositiveNumber_OK() {
        double firstArgument = -4.0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = -2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_NegativeNumber_VS_DoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_Division_MinusDoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_Zero_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_DoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_MinusDoubleMin_VS_DoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  Zero
     */
    @Test
    void calculate_Division_Zero_VS_MinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_Zero_VS_NegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_Zero_VS_MinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_Zero_VS_Zero_notOK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_Zero_VS_DoubleMin_OK() {
        double firstArgument = 0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_Zero_VS_PositiveNumber_OK() {
        double firstArgument = 0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_Zero_VS_DoubleMax_OK() {
        double firstArgument = 0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_Division_DoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMin_VS_Zero_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_DoubleMin_VS_DoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMin_VS_DoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  positive number
     */
    @Test
    void calculate_Division_PositiveNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = 4.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_PositiveNumber_VS_NegativeNumber_OK() {
        double firstArgument = 4.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = -2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_PositiveNumber_VS_MinusDoubleMin_notOK() {
        double firstArgument = 4.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_PositiveNumber_VS_Zero_notOK() {
        double firstArgument = 4.0;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_PositiveNumber_VS_DoubleMin_notOK() {
        double firstArgument = 4.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_PositiveNumber_VS_PositiveNumber_OK() {
        double firstArgument = 4.0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_PositiveNumber_VS_DoubleMax_OK() {
        double firstArgument = 4.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter : MAX_VALUE
     */
    @Test
    void calculate_Division_DoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = -Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMax_VS_MinusDoubleMin_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_DoubleMax_VS_Zero_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_DoubleMax_VS_DoubleMin_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Division_DoubleMax_VS_PositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Division_DoubleMax_VS_DoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_MinusDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_NegativeNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_Zero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_DoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_PositiveNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_MinusDoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter :  negative number
     */
    @Test
    void calculate_Multiplication_NegativeNumber_VS_MinusDoubleMax_notOK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_NegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_Zero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_DoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_PositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = -20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_NegativeNumber_VS_DoubleMax_notOK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_Zero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_DoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_MinusDoubleMin_VS_DoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  Zero
     */
    @Test
    void calculate_Multiplication_Zero_VS_MinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_NegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_MinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_Zero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_DoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_PositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_Zero_VS_DoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_Multiplication_DoubleMin_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_NegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_Zero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_DoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMin_VS_DoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  positive number
     */
    @Test
    void calculate_Multiplication_PositiveNumber_VS_MinusDoubleMax_notOK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_NegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = -20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_Zero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_DoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_PositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_PositiveNumber_VS_DoubleMax_notOK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter : MAX_VALUE
     */
    @Test
    void calculate_Multiplication_DoubleMax_VS_MinusDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_NegativeNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_Zero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_DoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_PositiveNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Multiplication_DoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_Power_MinusDoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_MinusDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_Zero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_DoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_PositiveNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 2;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter :  negative number
     */
    @Test
    void calculate_Power_NegativeNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_NegativeNumber_VS_NegativeNumber_OK() {
        double firstArgument = -2.0;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.25;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_NegativeNumber_VS_MinusDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_NegativeNumber_VS_Zero_OK() {
        double firstArgument = -2.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_NegativeNumber_VS_DoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_NegativeNumber_VS_PositiveNumber_OK() {
        double firstArgument = -2.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 4.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_NegativeNumber_VS_DoubleMax_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_Power_MinusDoubleMin_VS_MinusDoubleMax_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_NegativeNumber_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_MinusDoubleMin_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_Zero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_DoubleMin_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_MinusDoubleMin_VS_DoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  Zero
     */
    @Test
    void calculate_Power_Zero_VS_MinusDoubleMax_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_Zero_VS_NegativeNumber_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_Zero_VS_MinusDoubleMin_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_Zero_VS_Zero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_Zero_VS_DoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_Zero_VS_PositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_Zero_VS_DoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_Power_DoubleMin_VS_MinusDoubleMax_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_DoubleMin_VS_NegativeNumber_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_DoubleMin_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMin_VS_Zero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMin_VS_DoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMin_VS_PositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMin_VS_DoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  positive number
     */
    @Test
    void calculate_Power_PositiveNumber_VS_MinusDoubleMax_OK() {
        double firstArgument = 2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_NegativeNumber_OK() {
        double firstArgument = 2.0;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.25;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_MinusDoubleMin_OK() {
        double firstArgument = 2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_Zero_OK() {
        double firstArgument = 2.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_DoubleMin_OK() {
        double firstArgument = 2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_PositiveNumber_OK() {
        double firstArgument = 2.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 4.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_PositiveNumber_VS_DoubleMax_notOK() {
        double firstArgument = 2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter : MAX_VALUE
     */
    @Test
    void calculate_Power_DoubleMax_VS_MinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMax_VS_NegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMax_VS_MinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMax_VS_Zero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMax_VS_DoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Power_DoubleMax_VS_PositiveNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_Power_DoubleMax_VS_DoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }
}
