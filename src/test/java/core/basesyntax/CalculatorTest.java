package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void additionTest() {
        int sum2and2 = Calculator.calculate(2,2,'+');
        assertEquals(4,sum2and2);
    }
}