package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ADDITION:
                return add(a, b);
            case SUBTRACTION:
                return subtract(a, b);
            case DIVISION:
                return divide(a, b);
            case MULTIPLICATION:
                return multiply(a, b);
            case POWER:
                return raiseToPower(a, b);
            default:
                throw new IllegalArgumentException("Wrong operation");
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    private double multiply(double a, double b) {
        if (a == Double.MAX_VALUE && b > 1 || a > 1 && b == Double.MAX_VALUE) {
            throw new ArithmeticException("Too big values");
        }
        return a * b;
    }

    private double raiseToPower(double a, double b) {
        if (a < 0.0 && b % (int)b != 0.0 && b != 0) {
            throw new ArithmeticException("Can't have negative base and decimal exponent");
        }
        if (a == 0 && b < 0) {
            throw new ArithmeticException("Can't have zero base and negative exponent");
        }
        return Math.pow(a, b);
    }
}
