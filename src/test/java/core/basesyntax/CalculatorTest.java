package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void additionTest() {
        int sum1and0 = calculator.calculate(1, 0, '+');
        int sum0and1 = calculator.calculate(0, 1, '+');
        int sum2and2 = calculator.calculate(2, 2, '+');

        assertEquals(4,sum2and2);
    }
}