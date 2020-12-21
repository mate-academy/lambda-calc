package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestCalculator {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "^";

    @BeforeAll
    private Calculator getCalculator() {
        return new Calculator();
    }


    @Test
    private void addCalculate() {
        //  assertEquals(); +
    }

    @Test
    private void subCalculate() {
        //  assertEquals(); -
    }

    @Test
    private void divCalculate() {
        //  assertEquals(); /
    }

    @Test
    private void mulCalculate() {
        //  assertEquals(); *
    }

    @Test
    private void powCalculate() {
        //  assertEquals(); ^
    }

    @Test
    private void checkInvalidOperationSymbol() {
        //  assertEquals(); String problem null
        //  assertEquals(); String problem not equal operation
        //  assertEquals(); String problem big string

    }

    @Test
    private void arithmeticalErrors() {
        //  assertEquals(); divide by /
        // MAX_VALUE
        // MIN VALUE
        // MAX_VALUE
        // MIN VALUE
    }

}
