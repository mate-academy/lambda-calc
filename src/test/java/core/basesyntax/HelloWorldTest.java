package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorldTest {
    static final double delta = 0.0001;
    private static HelloWorld calculator;
    private double positive1;
    private double positive2;
    private double negative1;
    private double negative2;

    @BeforeAll
    static void beforeAll() {
        calculator = new HelloWorld();

    }

    @BeforeEach
    void setUp() {
        positive1 = 5;
        positive2 = 100;
        negative1 = -5;
        negative2 = -100;
    }

    @Test
    void calculate_Addition_TwoPositive_OK() {
        double actual = calculator.calculate(positive1, positive2,'+');
        assertEquals(105, actual);
    }

    @Test
    void calculate_Addition_TwoNegatives_OK() {
        double actual = calculator.calculate(negative1, negative2,'+');
        assertEquals(-105, actual);
    }

    @Test
    void calculate_Addition_OneNegatives_OK() {
        double actual = calculator.calculate(positive1, negative1,'+');
        assertEquals(0, actual);
        actual = calculator.calculate(negative2, positive2,'+');
        assertEquals(0, actual);
    }

    @Test
    void calculate_Addition_Zero_OK() {
        double actual = calculator.calculate(0, 0,'+');
        assertEquals(0, actual);
        actual = calculator.calculate(0, positive1,'+');
        assertEquals(positive1, actual);
        actual = calculator.calculate(positive2, 0,'+');
        assertEquals(positive2, actual);
        actual = calculator.calculate(negative1, 0,'+');
        assertEquals(negative1, actual);
        actual = calculator.calculate(0, negative2,'+');
        assertEquals(negative2, actual);
    }

    @Test
    void calculate_Addition_MaxNumber_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, positive2, '+');
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_Addition_MaxMax_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_Subtraction_TwoPositive_OK() {
        double actual = calculator.calculate(positive1, positive2,'-');
        assertEquals(-95, actual);
    }

    @Test
    void calculate_Subtraction_TwoNegatives_OK() {
        double actual = calculator.calculate(negative1, negative2,'-');
        assertEquals(95, actual);
    }

    @Test
    void calculate_Subtraction_OneNegatives_OK() {
        double actual = calculator.calculate(positive1, negative1,'-');
        assertEquals(10, actual);
        actual = calculator.calculate(negative2, positive2,'-');
        assertEquals(-200, actual);
    }

    @Test
    void calculate_Subtraction_Zero_OK() {
        double actual = calculator.calculate(0, 0,'-');
        assertEquals(0, actual);
        actual = calculator.calculate(0, positive1,'-');
        assertEquals(negative1, actual);
        actual = calculator.calculate(positive2, 0,'-');
        assertEquals(positive2, actual);
        actual = calculator.calculate(negative1, 0,'-');
        assertEquals(negative1, actual);
        actual = calculator.calculate(0, negative2,'-');
        assertEquals(positive2, actual);
    }

    @Test
    void calculate_Division_TwoPositive_OK() {
        double actual = calculator.calculate(positive1, positive2,'/');
        assertEquals(0.05, actual);
    }

    @Test
    void calculate_Division_TwoNegatives_OK() {
        double actual = calculator.calculate(negative1, negative2,'/');
        assertEquals(0.05, actual);
    }

    @Test
    void calculate_Division_OneNegatives_OK() {
        double actual = calculator.calculate(positive1, negative1,'/');
        assertEquals(-1, actual);
        actual = calculator.calculate(negative2, positive2,'/');
        assertEquals(-1, actual);
    }

    @Test
    void calculate_Division_byZero_OK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0,'/');
            calculator.calculate(positive2, 0,'/');
            calculator.calculate(negative1, 0,'/');
        });
    }

    @Test
    void calculate_Division_ZeroByNumber_OK() {
        double actual = calculator.calculate(0, positive1,'/');
        assertEquals(0.0, actual);
        actual = calculator.calculate(0, negative2,'/');
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_multiplication_TwoPositive_OK() {
        double actual = calculator.calculate(positive1, positive2,'*');
        assertEquals(500.0, actual);
    }

    @Test
    void calculate_multiplication_TwoNegatives_OK() {
        double actual = calculator.calculate(negative1, negative2,'*');
        assertEquals(500.0, actual);
    }

    @Test
    void calculate_multiplication_OneNegatives_OK() {
        double actual = calculator.calculate(positive1, negative1,'*');
        assertEquals(-25, actual);
        actual = calculator.calculate(negative2, positive2,'*');
        assertEquals(-10000.0, actual);
    }

    @Test
    void calculate_multiplication_byZero_OK() {
        double actual = calculator.calculate(0, 0,'*');
        assertEquals(0, actual);
        actual = calculator.calculate(negative1, 0,'*');
        assertEquals(-0.0, actual);
        actual = calculator.calculate(positive1, 0,'*');
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_multiplication_ZeroByNumber_OK() {
        double actual = calculator.calculate(0, positive1,'*');
        assertEquals(0.0, actual);
        actual = calculator.calculate(0, negative2,'*');
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_multiplication_Max_OK() {
        double actual = calculator.calculate(0, Double.MAX_VALUE,'*');
        assertEquals(0.0, actual);
        actual = calculator.calculate(positive1, Double.MAX_VALUE,'*');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(negative1, Double.MAX_VALUE,'*');
        assertEquals(Double.NEGATIVE_INFINITY, actual);
    }

    @Test
    void calculate_multiplication_ZeroMin_OK() {
        double actual = calculator.calculate(0, Double.MIN_VALUE,'*');
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_Raising_PositivePower_OK() {
        double actual = calculator.calculate(positive1,2,'^');
        assertEquals(25.0, actual);
        actual = calculator.calculate(negative1,2,'^');
        assertEquals(25.0, actual);
    }

    @Test
    void calculate_Raising_NegativePower_OK() {
        double actual = calculator.calculate(positive1, -2,'^');
        assertEquals(0.04, actual);
        actual = calculator.calculate(negative1, -2,'^');
        assertEquals(0.04, actual);
    }

    @Test
    void calculate_Raising_ZeroPower_OK() {
        double actual = calculator.calculate(positive1, 0,'^');
        assertEquals(1.0, actual);
        actual = calculator.calculate(negative1, 0,'^');
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_Raising_ZeroToPower_OK() {
        double actual = calculator.calculate(0, negative1,'^');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(0, positive1,'^');
        assertEquals(0, actual);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(positive1, positive2,'?');
            calculator.calculate(positive1, positive2,'!');
            calculator.calculate(positive1, positive2,'a');
        });
    }

}
