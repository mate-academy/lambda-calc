package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER_RAISING = '^';

    public double calculate(double a, double b, char action) {
        switch (action) {
            case ADDITION :
                return add(a, b);
            case SUBTRACTION :
                return subtract(a, b);
            case DIVISION :
                return divide(a, b);
            case MULTIPLICATION :
                return multiply(a,b);
            case POWER_RAISING :
                return pow(a, b);
            default :
                throw new IllegalArgumentException("No such action in calculator");

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
            throw new ArithmeticException("Can't divide by zero");
        }
        return a / b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double pow(double a, double b) {
        return Math.pow(a, b);
    }
}
