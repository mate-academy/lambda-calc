package core.basesyntax;

import core.basesyntax.exeptions.InvalidOperationException;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by 0 is forbidden");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new InvalidOperationException("Unexpected operation");
        }
    }
}
