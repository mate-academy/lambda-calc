package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double firstPositive;
    private double secondPostive;
    private double firstNegative;
    private double secondNegative;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @BeforeEach
    void setUp() {
        firstPositive = 2;
        secondPostive = 100;
        firstNegative = -2;
        secondNegative = -100;
    }

    @Test
    void calculate_Addition_TwoPositive_OK() {
        double actual = calculator.calculate(firstPositive, secondPostive,'+');
        assertEquals(firstPositive + secondPostive, actual);
    }

    @Test
    void calculate_Addition_TwoNegatives_OK() {
        double actual = calculator.calculate(firstNegative, secondNegative,'+');
        assertEquals(firstNegative + secondNegative, actual);
    }

    @Test
    void calculate_Addition_OneNegatives_OK() {
        double actual = calculator.calculate(firstPositive, firstNegative,'+');
        assertEquals(firstPositive + firstNegative, actual);
        actual = calculator.calculate(secondNegative, secondPostive,'+');
        assertEquals(secondNegative + secondPostive, actual);
    }

    @Test
    void calculate_Addition_Zero_OK() {
        double actual = calculator.calculate(0, 0,'+');
        assertEquals(0, actual);
        actual = calculator.calculate(0, firstPositive,'+');
        assertEquals(firstPositive, actual);
        actual = calculator.calculate(secondPostive, 0,'+');
        assertEquals(secondPostive, actual);
        actual = calculator.calculate(firstNegative, 0,'+');
        assertEquals(firstNegative, actual);
        actual = calculator.calculate(0, secondNegative,'+');
        assertEquals(secondNegative, actual);
    }

    @Test
    void calculate_Addition_MaxNumber_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, secondPostive, '+');
        assertEquals(Double.MAX_VALUE + secondPostive, actual);
    }

    @Test
    void calculate_Addition_MaxMax_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_Subtraction_TwoPositive_OK() {
        double actual = calculator.calculate(firstPositive, secondPostive,'-');
        assertEquals(firstPositive - secondPostive, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_TwoNegatives_OK() {
        double actual = calculator.calculate(firstNegative, secondNegative,'-');
        assertEquals(firstNegative - secondNegative, actual, DELTA);
    }

    @Test
    void calculate_Subtraction_OneNegatives_OK() {
        double actual = calculator.calculate(firstPositive, firstNegative,'-');
        assertEquals(firstPositive - firstNegative, actual, DELTA);
        actual = calculator.calculate(secondNegative, secondPostive,'-');
        assertEquals(secondNegative - secondPostive, actual);
    }

    @Test
    void calculate_Subtraction_Zero_OK() {
        double actual = calculator.calculate(0, 0,'-');
        assertEquals(0, actual, DELTA);
        actual = calculator.calculate(0, firstPositive,'-');
        assertEquals(firstNegative, actual, DELTA);
        actual = calculator.calculate(secondPostive, 0,'-');
        assertEquals(secondPostive, actual, DELTA);
        actual = calculator.calculate(firstNegative, 0,'-');
        assertEquals(firstNegative, actual, DELTA);
        actual = calculator.calculate(0, secondNegative,'-');
        assertEquals(secondPostive, actual, DELTA);
    }

    @Test
    void calculate_Division_TwoPositive_OK() {
        double actual = calculator.calculate(firstPositive, secondPostive,'/');
        assertEquals(firstPositive / secondPostive, actual, DELTA);
    }

    @Test
    void calculate_Division_TwoNegatives_OK() {
        double actual = calculator.calculate(firstNegative, secondNegative,'/');
        assertEquals(firstNegative / secondNegative, actual, DELTA);
    }

    @Test
    void calculate_Division_OneNegatives_OK() {
        double actual = calculator.calculate(firstPositive, firstNegative,'/');
        assertEquals(firstPositive / firstNegative, actual, DELTA);
        actual = calculator.calculate(secondNegative, secondPostive,'/');
        assertEquals(secondNegative / secondPostive, actual, DELTA);
    }

    @Test
    void calculate_Division_byZero_OK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0,'/');
            calculator.calculate(secondPostive, 0,'/');
            calculator.calculate(firstNegative, 0,'/');
        });
    }

    @Test
    void calculate_Division_ZeroByNumber_OK() {
        double actual = calculator.calculate(0, firstPositive,'/');
        assertEquals(0.0, actual, DELTA);
        actual = calculator.calculate(0, secondNegative,'/');
        assertEquals(-0.0, actual, DELTA);
    }

    @Test
    void calculate_multiplication_TwoPositive_OK() {
        double actual = calculator.calculate(firstPositive, secondPostive,'*');
        assertEquals(firstPositive * secondPostive, actual);
    }

    @Test
    void calculate_multiplication_TwoNegatives_OK() {
        double actual = calculator.calculate(firstNegative, secondNegative,'*');
        assertEquals(firstNegative * secondNegative, actual);
    }

    @Test
    void calculate_multiplication_OneNegatives_OK() {
        double actual = calculator.calculate(firstPositive, firstNegative,'*');
        assertEquals(firstPositive * firstNegative, actual);
        actual = calculator.calculate(secondNegative, secondPostive,'*');
        assertEquals(secondNegative * secondPostive, actual);
    }

    @Test
    void calculate_multiplication_byZero_OK() {
        double actual = calculator.calculate(0, 0,'*');
        assertEquals(0, actual);
        actual = calculator.calculate(firstNegative, 0,'*');
        assertEquals(-0.0, actual);
        actual = calculator.calculate(firstPositive, 0,'*');
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_multiplication_ZeroByNumber_OK() {
        double actual = calculator.calculate(0, firstPositive,'*');
        assertEquals(0.0, actual);
        actual = calculator.calculate(0, secondNegative,'*');
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_multiplication_Max_OK() {
        double actual = calculator.calculate(0, Double.MAX_VALUE,'*');
        assertEquals(0.0, actual);
        actual = calculator.calculate(firstPositive, Double.MAX_VALUE,'*');
        assertEquals(firstPositive * Double.MAX_VALUE, actual);
        actual = calculator.calculate(firstNegative, Double.MAX_VALUE,'*');
        assertEquals(firstNegative * Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_multiplication_ZeroMin_OK() {
        double actual = calculator.calculate(0, Double.MIN_VALUE,'*');
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_Raising_PositivePower_OK() {
        double actual = calculator.calculate(firstPositive,firstPositive,'^');
        assertEquals(Math.pow(firstPositive, firstPositive), actual, DELTA);
        actual = calculator.calculate(firstNegative,firstPositive,'^');
        assertEquals(Math.pow(firstNegative, firstPositive), actual, DELTA);
    }

    @Test
    void calculate_Raising_NegativePower_OK() {
        double actual = calculator.calculate(firstPositive, firstNegative,'^');
        assertEquals(Math.pow(firstPositive, firstNegative), actual, DELTA);
        actual = calculator.calculate(firstNegative, firstNegative,'^');
        assertEquals(Math.pow(firstNegative, firstNegative), actual, DELTA);
    }

    @Test
    void calculate_Raising_ZeroPower_OK() {
        double actual = calculator.calculate(firstPositive, 0,'^');
        assertEquals(Math.pow(firstPositive, 0), actual, DELTA);
        actual = calculator.calculate(firstNegative, 0,'^');
        assertEquals(Math.pow(firstNegative, 0), actual, DELTA);
    }

    @Test
    void calculate_Raising_ZeroToPower_OK() {
        double actual = calculator.calculate(0, firstNegative,'^');
        assertEquals(Math.pow(0, firstNegative), actual, DELTA);
        actual = calculator.calculate(0, firstPositive,'^');
        assertEquals(Math.pow(0, firstPositive), actual, DELTA);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(firstPositive, secondPostive,'?');
            calculator.calculate(firstPositive, secondPostive,'!');
            calculator.calculate(firstPositive, secondPostive,'a');
        });
    }
}
