package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int MIN_VALUE = Integer.MIN_VALUE;
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "p";
    private static final String POW_UPPERCASE = "P";

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void case_insensitive_operation_input_Ok() {
        try {
            calculator.calculate(0, 0, POW_UPPERCASE);
        } catch (RuntimeException e) {
            fail("Method should be case insensitive");
        }
    }

    @Test
    void operation_input_NotOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(0, 0, "c"));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(0, 0, "1"));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(0, 0, "z"));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(0, 0, "]"));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(0, 0, "#"));
    }

    @Test
    void null_operation_input_NotOk() {
        assertThrows(NullPointerException.class,
                () -> calculator.calculate(0, 0, null));
    }

    @Test
    void divide_by_zero_Ok() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, DIV));
    }

    @Test
    void divide_max_positives_Ok() {
        Assertions.assertEquals((double) MAX_VALUE / MAX_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, DIV));
    }

    @Test
    void divide_min_negatives_Ok() {
        Assertions.assertEquals((double) MIN_VALUE / MIN_VALUE,
                calculator.calculate(MIN_VALUE, MIN_VALUE, DIV));
    }

    @Test
    void divide_max_positive_by_negative_Ok() {
        Assertions.assertEquals((double) MAX_VALUE / MIN_VALUE,
                calculator.calculate(MAX_VALUE, MIN_VALUE, DIV));
    }

    @Test
    void add_max_positive_Ok() {
        Assertions.assertEquals((double) MAX_VALUE + MAX_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, ADD));
    }

    @Test
    void add_max_positive_NotOk() {
        Assertions.assertNotEquals(MAX_VALUE + MAX_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, ADD));
    }

    @Test
    void add_max_positive_and_negative_Ok() {
        Assertions.assertEquals((double) MAX_VALUE + MIN_VALUE,
                calculator.calculate(MAX_VALUE, MIN_VALUE, ADD));
    }

    @Test
    void add_min_negative_Ok() {
        Assertions.assertEquals((double) MIN_VALUE + MIN_VALUE,
                calculator.calculate(MIN_VALUE, MIN_VALUE, ADD));
    }

    @Test
    void add_min_NotOk() {
        Assertions.assertNotEquals(MIN_VALUE + MIN_VALUE,
                calculator.calculate(MIN_VALUE, MIN_VALUE, ADD));
    }

    @Test
    void add_negative_Ok() {
        Assertions.assertEquals((double) MAX_VALUE + MIN_VALUE,
                calculator.calculate(MAX_VALUE, MIN_VALUE, ADD));
    }

    @Test
    void subtract_max_positives_Ok() {
        Assertions.assertEquals((double) MAX_VALUE - MAX_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, SUB));
    }

    @Test
    void subtract_min_negatives_Ok() {
        Assertions.assertEquals((double) MIN_VALUE - MIN_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, SUB));
    }

    @Test
    void subtract_max_positive_and_negative() {
        Assertions.assertEquals((double) MAX_VALUE - MIN_VALUE,
                calculator.calculate(MAX_VALUE, MIN_VALUE, SUB));
    }

    @Test
    void multiply_max_positives_Ok() {
        Assertions.assertEquals((double) MAX_VALUE * MAX_VALUE,
                calculator.calculate(MAX_VALUE, MAX_VALUE, MUL));
    }

    @Test
    void multiply_min_positives_Ok() {
        Assertions.assertEquals((double) MIN_VALUE * MIN_VALUE,
                calculator.calculate(MIN_VALUE, MIN_VALUE, MUL));
    }

    @Test
    void multiply_max_positive_and_negative_Ok() {
        Assertions.assertEquals((double) MAX_VALUE * MIN_VALUE,
                calculator.calculate(MAX_VALUE, MIN_VALUE, MUL));
    }

    @Test
    void power_random_test() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt(1000);
            b = new Random().nextInt(1000);
            if (Math.pow(a, b) != calculator.calculate(a, b, POW)) {
                fail("Expected value " + Math.pow(a, b)
                        + "but was " + calculator.calculate(a, b, POW));
            }
        }
    }

    @Test
    void negative_power_random_test() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt(1000);
            b = new Random().nextInt(1000) * (-1);
            if (Math.pow(a, b) != calculator.calculate(a, b, POW)) {
                fail("Expected value " + Math.pow(a, b)
                        + "but was " + calculator.calculate(a, b, POW));
            }
        }
    }

    @Test
    void random_input_addition() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt();
            b = new Random().nextInt();
            if ((double) a + b != calculator.calculate(a, b, ADD)) {
                fail("Expected value " + (double) a + b
                        + "but was " + calculator.calculate(a, b, ADD));
            }
        }
    }

    @Test
    void random_input_subtraction() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt();
            b = new Random().nextInt();
            if ((double) a - b != calculator.calculate(a, b, SUB)) {
                fail("Expected value " + ((double) a - b)
                        + "but was " + calculator.calculate(a, b, SUB));
            }
        }
    }

    @Test
    void random_input_multiplication() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt();
            b = new Random().nextInt();
            if ((double) a * b != calculator.calculate(a, b, MUL)) {
                fail("Expected value " + (double) a * b
                        + "but was " + calculator.calculate(a, b, MUL));
            }
        }
    }

    @Test
    void random_input_division() {
        int a;
        int b;
        for (int i = 0; i < 1000; i++) {
            a = new Random().nextInt();
            b = new Random().nextInt();
            if ((double) a / b != calculator.calculate(a, b, DIV)) {
                Assertions.fail("Expected value " + (double) a / b
                        + "but was " + calculator.calculate(a, b, DIV));
            }
        }
    }
}
