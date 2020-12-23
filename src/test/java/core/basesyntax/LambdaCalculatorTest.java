package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LambdaCalculatorTest {
    private static LambdaCalculator calculator;
    private static final int TWENTY = 20;
    private static final int FIFTEEN = 15;
    private static final int ONE_HUNDRED = 100;
    private static final int FIFTY = 50;
    private static final int ZERO = 0;
    private static final int FIFTY_SIX_THOUSANDS = 56000;
    private static final int ONE = 1;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    @BeforeAll
    public static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    public void testForAddition() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, ADDITION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, ADDITION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, ADDITION);
        double firstExpected = 4.294967294E9;
        double secondExpected = 35;
        double thirdExpected = -50;
        assertEquals(firstExpected, firstActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        secondExpected, secondActual));
        assertEquals(thirdExpected, thirdActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        thirdExpected, thirdActual));
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, ADDITION);
        double fourthExpected = 56000;
        assertEquals(fourthExpected,fourthActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        fourthExpected, fourthActual));
    }

    @Test
    public void testForSubtraction() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE,
                SUBTRACTION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, SUBTRACTION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, SUBTRACTION);
        double firstExpected = 0;
        double secondExpected = 5;
        double thirdExpected = -150;
        assertEquals(firstExpected, firstActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        secondExpected, secondActual));
        assertEquals(thirdExpected, thirdActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        thirdExpected, thirdActual));
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, SUBTRACTION);
        double fourthExpected = -56000;
        assertEquals(fourthExpected, fourthActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        fourthExpected, fourthActual));
    }

    @Test
    public void testForDivision() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, DIVISION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, DIVISION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, DIVISION);
        double firstExpected = 1;
        double secondExpected = 1.3333333333333333;
        double thirdExpected = -2;
        assertEquals(firstExpected, firstActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        secondExpected, secondActual));
        assertEquals(thirdExpected, thirdActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        thirdExpected, thirdActual));
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, DIVISION);
        double fourthExpected = 0;
        assertEquals(fourthExpected, fourthActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        fourthExpected, fourthActual));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(TWENTY, ZERO, DIVISION));

    }

    @Test
    public void testForMultiplication() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE,
                MULTIPLICATION);
        double secondActual = calculator.calculate(TWENTY, FIFTEEN, MULTIPLICATION);
        double thirdActual = calculator.calculate(-ONE_HUNDRED, FIFTY, MULTIPLICATION);
        double firstExpected = 4.6116860141324206E18;
        double secondExpected = 300;
        double thirdExpected = -5000;
        assertEquals(firstExpected, firstActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        firstExpected, firstActual));
        assertEquals(secondExpected,secondActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        secondExpected, secondActual));
        assertEquals(thirdExpected,thirdActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        thirdExpected, thirdActual));
        double fourthActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, MULTIPLICATION);
        double fourthExpected = 0;
        assertEquals(fourthExpected, fourthActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        fourthExpected, fourthActual));
    }

    @Test
    public void testForRaisingToAPower() {
        double firstActual = calculator.calculate(TWENTY, TWENTY, RAISING_TO_A_POWER);
        double secondActual = calculator.calculate(ZERO, FIFTY_SIX_THOUSANDS, RAISING_TO_A_POWER);
        double thirdActual = calculator.calculate(FIFTY, ZERO, RAISING_TO_A_POWER);
        double firstExpected = 1.048576E26;
        double secondExpected = 0;
        double thirdExpected = 1;
        assertEquals(firstExpected,firstActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        firstExpected, firstActual));
        assertEquals(secondExpected,secondActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        secondExpected, secondActual));
        assertEquals(thirdExpected,thirdActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        thirdExpected, thirdActual));
        double fourthActual = calculator.calculate(ONE_HUNDRED, ONE,
                RAISING_TO_A_POWER);
        double fourthExpected = 100;
        assertEquals(fourthExpected,fourthActual,
                String.format("Wrong operation! expected: %f But was: %f",
                        fourthExpected, fourthActual));
    }

    @Test
    public void testForBadOperator() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(10, 5, '!'));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, '['));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, '0'));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(25, 5, 'a'));
    }
}

