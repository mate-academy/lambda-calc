package core.basesyntax;

public class Calculator {
    private static final String EXCEPTION_MESSAGE = "Unknown operand";

    public double calculate(double a, double b, char operation) {
        if (operation == '+') {
            return a + b;
        }
        if (operation == '-') {
            return a - b;
        }
        if (operation == '*') {
            return a * b;
        }
        if (operation == '/') {
            return a / b;
        }
        if (operation == '^') {
            return Math.pow(a, b);
        }
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }
}
