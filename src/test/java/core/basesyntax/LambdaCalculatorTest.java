package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static LambdaCalculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void testForAddition() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '+');
        double secondActual = calculator.calculate(20, 15, '+');
        double thirdActual = calculator.calculate(-100, 50, '+');
        assertEquals(-2,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + -2 + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(35,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + 35 + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(-50,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + -50 + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(0, 56845, '+');
        assertEquals(56845,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + 56845 + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForSubtraction() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '-');
        double secondActual = calculator.calculate(20, 15, '-');
        double thirdActual = calculator.calculate(-100, 50, '-');
        assertEquals(0,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + 0 + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(5,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + 5 + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(-150,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + -150 + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(0, 56845, '-');
        assertEquals(-56845,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + -56845 + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForDivision() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '/');
        double secondActual = calculator.calculate(20, 10, '/');
        double thirdActual = calculator.calculate(-100, 50, '/');
        assertEquals(1,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + 1 + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(2,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + 2 + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(-2,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + -2 + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(0, 56845, '/');
        assertEquals(0,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + 0 + System.lineSeparator()
                + "But was:" + fourthActual);
        assertThrows(ArithmeticException.class, () -> calculator.calculate(25, 0, '/'));

    }

    @Test
    void testForMultiplication() {
        double firstActual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*');
        double secondActual = calculator.calculate(20, 15, '*');
        double thirdActual = calculator.calculate(-100, 50, '*');
        assertEquals(1,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + 1 + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(300,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + 300 + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(-5000,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + -5000 + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(0, 56845, '*');
        assertEquals(0,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + 0 + System.lineSeparator()
                + "But was:" + fourthActual);
    }

    @Test
    void testForRaisingToAPower() {
        double firstActual = calculator.calculate(10, 1, '^');
        double secondActual = calculator.calculate(2, 10, '^');
        double thirdActual = calculator.calculate(5, 0, '^');
        assertEquals(10,firstActual, "Wrong operation! expected:"
                + System.lineSeparator() + 10 + System.lineSeparator()
                + "But was:" + firstActual);
        assertEquals(1024,secondActual, "Wrong operation! expected:"
                + System.lineSeparator() + 1024 + System.lineSeparator()
                + "But was:" + secondActual);
        assertEquals(1,thirdActual, "Wrong operation! expected:"
                + System.lineSeparator() + 1 + System.lineSeparator()
                + "But was:" + thirdActual);
        double fourthActual = calculator.calculate(1, 150, '^');
        assertEquals(1,fourthActual, "Wrong operation! expected:"
                + System.lineSeparator() + 1 + System.lineSeparator()
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

