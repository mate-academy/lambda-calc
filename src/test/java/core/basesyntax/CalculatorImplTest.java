package core.basesyntax;

import static core.basesyntax.ArithmeticOperation.ADD;
import static core.basesyntax.ArithmeticOperation.DIV;
import static core.basesyntax.ArithmeticOperation.MUL;
import static core.basesyntax.ArithmeticOperation.POW;
import static core.basesyntax.ArithmeticOperation.SUB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorImplTest {
    private static Calculator testCalc;
    private static String MESSAGE = "Rejected";

    @BeforeAll
    public static void beforeAll() {
        testCalc = new CalculatorImpl();
    }

    @Test
    public void additionOK() {
        assertEquals(20, testCalc.calculate(5, 15, ADD), MESSAGE);
        assertEquals(9, testCalc.calculate(-6, 15, ADD), MESSAGE);
        assertEquals(-8, testCalc.calculate(12, -20, ADD), MESSAGE);
        assertEquals(-25, testCalc.calculate(-15, -10, ADD), MESSAGE);
        assertEquals(10, testCalc.calculate(0, 10, ADD), MESSAGE);
        assertEquals(6, testCalc.calculate(6, 0, ADD), MESSAGE);
        assertEquals(10000, testCalc.calculate(10, 9990, ADD), MESSAGE);
    }

    @Test
    public void subtractionOK() {
        assertEquals(8, testCalc.calculate(10, 2, SUB), MESSAGE);
        assertEquals(-26, testCalc.calculate(-16, 10, SUB), MESSAGE);
        assertEquals(25, testCalc.calculate(13, -12, SUB), MESSAGE);
        assertEquals(-4, testCalc.calculate(-10, -6, SUB), MESSAGE);
        assertEquals(-10, testCalc.calculate(0, 10, SUB), MESSAGE);
        assertEquals(6, testCalc.calculate(6, 0, SUB), MESSAGE);
        assertEquals(-10000, testCalc.calculate(4, 10004, SUB), MESSAGE);
    }

    @Test
    public void multiplicationOK() {
        assertEquals(102, testCalc.calculate(6, 17, MUL), MESSAGE);
        assertEquals(-98, testCalc.calculate(-14, 7, MUL), MESSAGE);
        assertEquals(-120, testCalc.calculate(10, -12, MUL), MESSAGE);
        assertEquals(117, testCalc.calculate(-13, -9, MUL), MESSAGE);
        assertEquals(0, testCalc.calculate(0, 10, MUL), MESSAGE);
        assertEquals(0, testCalc.calculate(6, 0, MUL), MESSAGE);
        assertEquals(10000, testCalc.calculate(8, 1250, MUL), MESSAGE);
    }

    @Test
    public void divisionOK() {
        assertEquals(4, testCalc.calculate(8, 2, DIV), MESSAGE);
        assertEquals(-3, testCalc.calculate(-6, 2, DIV), MESSAGE);
        assertEquals(-3, testCalc.calculate(18, -6, DIV), MESSAGE);
        assertEquals(1, testCalc.calculate(-4, -4, DIV), MESSAGE);
        assertEquals(0, testCalc.calculate(0, 10, DIV), MESSAGE);
        assertEquals(500, testCalc.calculate(10000, 20, DIV), MESSAGE);
    }

    @Test
    public void divToZero() {
        assertThrows(ArithmeticException.class,
                () -> testCalc.calculate(5, 0, DIV));
    }

    @Test
    public void powerOK() {
        assertEquals(256, testCalc.calculate(2, 8, POW), MESSAGE);
        assertEquals(36, testCalc.calculate(-6, 2, POW), MESSAGE);
        assertEquals(0.04, testCalc.calculate(5, -2, POW), MESSAGE);
        assertEquals(0.00390625, testCalc.calculate(-4, -4, POW), MESSAGE);
        assertEquals(1, testCalc.calculate(1, 10, POW), MESSAGE);
        assertEquals(1, testCalc.calculate(10, 0, POW), MESSAGE);
        assertEquals(1, testCalc.calculate(-13, 0, POW), MESSAGE);
        assertEquals(0, testCalc.calculate(0, 2, POW), MESSAGE);
        assertEquals(500, testCalc.calculate(500, 1, POW), MESSAGE);
    }

    @Test
    public void boundaryValues() {
        assertThrows(ArithmeticException.class,
                () -> testCalc.calculate(Double.MAX_VALUE, 1, ADD));
        assertThrows(ArithmeticException.class,
                () -> testCalc.calculate(Double.MIN_VALUE, 1, SUB));
        assertThrows(ArithmeticException.class,
                () -> testCalc.calculate(Double.MAX_VALUE, 2, MUL));
        assertEquals(0, testCalc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUB));
        assertEquals(0, testCalc.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUB));
    }
}
