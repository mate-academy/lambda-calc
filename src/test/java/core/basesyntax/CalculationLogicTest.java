package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.InfinityException;
import core.basesyntax.exceptions.UnexpectedOperandException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationLogicTest {
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final double PLUS_INFINITY = Double.POSITIVE_INFINITY;
    private static final double MINUS_INFINITY = Double.NEGATIVE_INFINITY;
    private static final NumberFormat FORMAT = new DecimalFormat("0.00");

    private static CalculationLogic current;

    @BeforeAll
    public static void setUp() {
        current = new CalculationLogic();
    }

    @Test
    public void illegalOperation_NotOk() {
        assertThrows(UnexpectedOperandException.class,
                () -> current.calculation(67.4, 5.36, 'x'));
        assertThrows(UnexpectedOperandException.class,
                () -> current.calculation(5.73, 67.45, '3'));
        assertThrows(UnexpectedOperandException.class,
                () -> current.calculation(0, 67.45, '!'));
    }

    @Test
    public void additionTest_Ok() {
        assertEquals(10.78, Double.parseDouble(FORMAT.format(
                current.calculation(4, 6.78, '+'))));
        assertEquals(123.15, Double.parseDouble(FORMAT.format(
                current.calculation(567.93, -444.78, '+'))));
        assertEquals(-47.89, Double.parseDouble(FORMAT.format(
                current.calculation(-54.67, 6.78, '+'))));
        assertEquals(-50.78, Double.parseDouble(FORMAT.format(
                current.calculation(-4, -46.78, '+'))));
        assertEquals(0, Double.parseDouble(FORMAT.format(
                current.calculation(0, 0, '+'))));
        assertEquals(-46.78, Double.parseDouble(FORMAT.format(
                current.calculation(0, -46.78, '+'))));
        assertEquals(PLUS_INFINITY,
                current.calculation(MAX, MAX, '+'));
        assertEquals(0,
                current.calculation(MIN, -MIN, '+'));
    }

    @Test
    public void subtractionTest_Ok() {
        assertEquals(3, Double.parseDouble(FORMAT.format(
                current.calculation(7.65, 4.65, '-'))));
        assertEquals(-5.4, Double.parseDouble(FORMAT.format(
                current.calculation(0, 5.4, '-'))));
        assertEquals(12.3, Double.parseDouble(FORMAT.format(
                current.calculation(7.65, -4.65, '-'))));
        assertEquals(-781.38, Double.parseDouble(FORMAT.format(
                current.calculation(-775.98, 5.4, '-'))));
        assertEquals(13.91, Double.parseDouble(FORMAT.format(
                current.calculation(-21.56, -35.47, '-'))));
        assertEquals(MINUS_INFINITY,
                current.calculation(-MAX, MAX, '-'));
        assertEquals(0,
                current.calculation(MIN, MIN, '-'));
    }

    @Test
    public void multiplicationTest_Ok() {
        assertEquals(25, Double.parseDouble(FORMAT.format(
                current.calculation(5, 5, '*'))));
        assertEquals(-25, Double.parseDouble(FORMAT.format(
                current.calculation(-5, 5, '*'))));
        assertEquals(125, Double.parseDouble(FORMAT.format(
                current.calculation(-25, -5, '*'))));
        assertEquals(0, Double.parseDouble(FORMAT.format(
                current.calculation(5, 0, '*'))));
        assertEquals(0, Double.parseDouble(FORMAT.format(
                current.calculation(0, -5, '*'))));
        assertThrows(InfinityException.class,
                () -> current.calculation(MAX, MAX,'*'));
    }

    @Test
    public void divisionTest_Ok() {
        assertEquals(1.33, Double.parseDouble(FORMAT.format(
                current.calculation(4, 3, '/'))));
        assertEquals(4, Double.parseDouble(FORMAT.format(
                current.calculation(12, 3, '/'))));
        assertEquals(0,
                current.calculation(0, MAX, '/'));
        assertEquals(-2, Double.parseDouble(FORMAT.format(
                current.calculation(-4, 2, '/'))));
        assertEquals(3, Double.parseDouble(FORMAT.format(
                current.calculation(-12, -4, '/'))));
        assertThrows(ArithmeticException.class,
                () -> current.calculation(500, 0, '/'));
    }

    @Test
    public void powerTest_Ok() {
        assertEquals(4, Double.parseDouble(FORMAT.format(
                current.calculation(2, 2, '^'))));
        assertEquals(0.25, Double.parseDouble(FORMAT.format(
                current.calculation(2, -2, '^'))));
        assertEquals(0, Double.parseDouble(FORMAT.format(
                current.calculation(0, 5.4, '^'))));
        assertEquals(1, Double.parseDouble(FORMAT.format(
                current.calculation(5.23, 0, '^'))));
        assertEquals(1,
                current.calculation(-4, 0, '^'));
        assertEquals(PLUS_INFINITY,
                current.calculation(0, -3, '^'));
        assertEquals(1, Double.parseDouble(FORMAT.format(
                current.calculation(MIN, MIN, '^'))));
        assertThrows(InfinityException.class,
                () -> current.calculation(MAX, MAX, '^'));
    }
}
