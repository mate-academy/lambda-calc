package core.basesyntax;

import core.basesyntax.exeptions.InvalidOperationException;

public class CalculatorImpl implements Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    @Override
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Division by 0 is forbidden");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                throw new InvalidOperationException("Unexpected operation");
        }
    }
}
