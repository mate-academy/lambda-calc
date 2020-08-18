package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';

    public double calculate(double a, double b, char action) {
        switch (action) {
            case PLUS:
                return addition(a, b);
            case MINUS:
                return subtraction(a, b);
            case MULTIPLY:
                return multiplication(a, b);
            case DIVIDE:
                return division(a, b);
            case POW:
                return raisingToThePower(a, b);
            default:
                throw new IllegalArgumentException("No such sign");
        }
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("We can't divide on zero!");
        }
        return a / b;
    }

    private double raisingToThePower(double a, double b) {
        return Math.pow(a, b);
    }
}
