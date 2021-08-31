package core.basesyntax;

import core.basesyntax.calculator.Calculator;
import core.basesyntax.calculator.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        calculator.calculate(10, 10, '+');
    }
}
