package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
    calculator = new CalculatorImpl();
    }

/*   @BeforeAll
    void setUp() {
        calculator = new CalculatorImp(Double.MIN_VALUE, Double.MIN_VALUE);
        calculator = new CalculatorImp(-45.936530, Double.MIN_VALUE);
        calculator = new CalculatorImp(-53.343, -0.3456);
        calculator = new CalculatorImp(104.4567, Double.MIN_VALUE);
        calculator = new CalculatorImp(0.0, -3567.0224687);
        calculator = new CalculatorImp(104.4567, -567.042345);
        calculator = new CalculatorImp(-102.061387, Double.MAX_VALUE);
        calculator = new CalculatorImp(Double.MIN_VALUE, Double.MAX_VALUE);
        calculator = new CalculatorImp(0.0, 0.0);
        calculator = new CalculatorImp(0.456779, 0.0);
        calculator = new CalculatorImp(0.152438, 124.093161);
        calculator = new CalculatorImp(104.456779, 3567.042345);
        calculator = new CalculatorImp(Double.MAX_VALUE, Double.MAX_VALUE);
    } */

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        expected = 0.152438 + 124.093161;
        actual = calculator.calculate(0.152438, 124.093161, '+');
        assertEquals(expected, actual, DELTA);
    }

  /*  @Test
    void calculate_additionWithTwoPositiveOperands_notOk() {
    }

    @Test
    void division_Ok() {

    }

    @Test
    void multiplication_Ok() {

    }

    @Test
    void raisingToAPower_Ok() {

    } */

}