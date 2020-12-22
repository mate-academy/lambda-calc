package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static LambdaCalculator calculator;
    private static final int TWENTY = 20;
    private static final int FIFTEEN = 15;
    private static final int ONE_HUNDRED = 100;
    private static final int FIFTY = 50;
    private static final int ZERO = 0;
    private static final int FIFTY_SIX_THOUSANDS = 56000;
    private static final int ADDITION_MAX_VALUE = -2;
    private static final int SUBTRACTION_MAX_VALUE = 0;
    private static final int DIVISION_MAX_VALUE = 1;
    private static final int MULTIPLICATION_MAX_VALUE = 1;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void testForAddition() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, ADDITION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, ADDITION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, ADDITION);
        double secondExpected = TWENTY + FIFTEEN;
        double thirdExpected = -ONE_HUNDRED + FIFTY;
        assertEquals(ADDITION_MAX_VALUE, firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + ADDITION_MAX_VALUE + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(secondExpected, secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + secondExpected + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(thirdExpected, thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + thirdExpected + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, ADDITION);
        double fourthExpected = ZERO + FIFTY_SIX_THOUSANDS;
        assertEquals(fourthExpected,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + fourthExpected + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForSubtraction() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE,
                SUBTRACTION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, SUBTRACTION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, SUBTRACTION);
        double secondExpected = TWENTY - FIFTEEN;
        double thirdExpected = -ONE_HUNDRED - FIFTY;
        assertEquals(SUBTRACTION_MAX_VALUE, firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + SUBTRACTION_MAX_VALUE + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(secondExpected, secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + secondExpected + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(thirdExpected, thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + thirdExpected + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, SUBTRACTION);
        double fourthExpected = ZERO - FIFTY_SIX_THOUSANDS;
        assertEquals(fourthExpected,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + fourthExpected + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForDivision() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, DIVISION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, DIVISION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, DIVISION);
        double secondExpected = (double) TWENTY / FIFTEEN;
        double thirdExpected = (double) -ONE_HUNDRED / FIFTY;
        assertEquals(DIVISION_MAX_VALUE, firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + DIVISION_MAX_VALUE + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(secondExpected, secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + secondExpected + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(thirdExpected, thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + thirdExpected + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, DIVISION);
        double fourthExpected = (double) ZERO / FIFTY_SIX_THOUSANDS;
        assertEquals(fourthExpected, fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + fourthExpected + System.lineSeparator()
                + "But was:" + fourthActual);
        assertThrows(ArithmeticException.class, () -> calculator.calculate(TWENTY, ZERO, DIVISION));

    }

    @Test
    void testForMultiplication() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE,
                MULTIPLICATION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, MULTIPLICATION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, MULTIPLICATION);
        double secondExpected = TWENTY * FIFTEEN;
        double thirdExpected = -ONE_HUNDRED * FIFTY;
        assertEquals(MULTIPLICATION_MAX_VALUE, firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + MULTIPLICATION_MAX_VALUE + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(secondExpected,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + secondExpected + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(thirdExpected,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + thirdExpected + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, MULTIPLICATION);
        double fourthExpected = 0;
        assertEquals(fourthExpected, fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + fourthExpected + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForRaisingToAPower() {
        double firstActual = calculator.calculate(TWENTY, TWENTY, RAISING_TO_A_POWER);
        double secondActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, RAISING_TO_A_POWER);
        double thirdActual = calculator.calculate(FIFTY, ZERO, RAISING_TO_A_POWER);
        double firstExpected = Math.pow(TWENTY, TWENTY);
        double secondExpected = Math.pow(ZERO, FIFTY_SIX_THOUSANDS);
        double thirdExpected = Math.pow(FIFTY, ZERO);
        assertEquals(firstExpected,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + firstExpected + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(secondExpected,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + secondExpected + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(thirdExpected,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + thirdExpected + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(ONE_HUNDRED, DIVISION_MAX_VALUE,
                RAISING_TO_A_POWER);
        double fourthExpected = Math.pow(ONE_HUNDRED, DIVISION_MAX_VALUE);
        assertEquals(fourthExpected,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + fourthExpected + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForBadOperator() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(10, 5, '!'));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, '['));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, '0'));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, 'a'));
    }
}

