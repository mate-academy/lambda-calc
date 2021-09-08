package core.basesyntax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    List<Calculator> calculatorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        calculatorList.add(new Calculator(Double.MIN_VALUE, Double.MIN_VALUE));
        calculatorList.add(new Calculator(-45.936530, Double.MIN_VALUE));
        calculatorList.add(new Calculator(-53.343, -0.3456));
        calculatorList.add(new Calculator(104.4567, Double.MIN_VALUE));
        calculatorList.add(new Calculator(0.0, -3567.0224687));
        calculatorList.add(new Calculator(104.4567, -567.042345));
        calculatorList.add(new Calculator(-102.061387, Double.MAX_VALUE));
        calculatorList.add(new Calculator(Double.MIN_VALUE, Double.MAX_VALUE));
        calculatorList.add(new Calculator(0.0, 0.0));
        calculatorList.add(new Calculator(0.456779, 0.0));
        calculatorList.add(new Calculator(0.152438, 124.093161));
        calculatorList.add(new Calculator(104.456779, 3567.042345));
        calculatorList.add(new Calculator(Double.MAX_VALUE, Double.MAX_VALUE));
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        double sumOfOperands = calculatorList.get(10).getFirstNumber() + calculatorList.get(10).getSecondNumber();
        assertEquals(calculatorList.get(10).calculate(calculatorList.get(10).getFirstNumber(),
                calculatorList.get(10).getSecondNumber(), '+'), sumOfOperands);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_notOk() {
        if (calculatorList.get(12).getFirstNumber() / 2 + calculatorList.get(12).getSecondNumber() / 2 > Double.MAX_VALUE / 2) {
            assertThrows(ArithmeticException.class, () -> {
                calculatorList.get(12).calculate(calculatorList.get(12).getFirstNumber(),
                        calculatorList.get(12).getSecondNumber(), '+');
            });
        }
    }

    @Test
    void division_Ok() {

    }

    @Test
    void multiplication_Ok() {

    }

    @Test
    void raisingToAPower_Ok() {

    }

}