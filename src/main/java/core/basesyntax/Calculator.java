package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double first, double second, char operator) {
        switch (operator) {
            case PLUS:
                return addition(first, second);
            case MINUS:
                return subtract(first, second);
            case MULTIPLY:
                return multiply(first, second);
            case DIVISION:
                return divide(first, second);
            case POWER:
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("This operator is not supported by Calculator");
        }
    }

    private double multiply(double first, double second) {
        return first * second;
    }

    private double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return first / second;
    }

    private double addition(double first, double second) {
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }
}
