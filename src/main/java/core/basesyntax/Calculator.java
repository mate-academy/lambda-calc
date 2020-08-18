package core.basesyntax;

public class Calculator {
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char DIVISION = '/';
    private final char MULTIPLICATION = '*';
    private final char RAISING_TO_POWER = '^';

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ADDITION: return add(a, b);
            case SUBTRACTION: return subtract(a, b);
            case DIVISION: return divide(a, b);
            case MULTIPLICATION: return multiply(a, b);
            case RAISING_TO_POWER: return raiseToPower(a, b);
            default: throw new UnsupportedOperationException("Operation " + operation + " is not supported.");
        }
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("We can't divide by zero.");
        }
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double raiseToPower(double a, double b) {
        return Math.pow(a, b);
    }
}
