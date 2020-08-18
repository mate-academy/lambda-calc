package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';

    public double calculate(double a, double b, char operation) {
        if (b == 0 && operation == DIVISION) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        switch (operation) {
            case ADDITION: return a + b;
            case SUBTRACTION: return a - b;
            case DIVISION: return a / b;
            case MULTIPLICATION: return a * b;
            case RAISING_TO_POWER: return Math.pow(a, b);
            default: throw new UnsupportedOperationException("Operation " + operation
                    + " is not supported.");
        }
    }
}
