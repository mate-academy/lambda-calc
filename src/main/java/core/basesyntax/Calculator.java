package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */

public class Calculator {
    private static final char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final char SUBTRACT = '-';
    private static final char DIVIDE = '/';
    private static final char RAISING_TO_THE_POWER = '^';
    private static final double ZERO_VALUE = 0.0;

    public static double calculate(double a, double b, char signal) {
        switch (signal) {
            case PLUS:
                return additional(a, b);
            case MULTIPLY:
                return multiplication(a, b);
            case SUBTRACT:
                return subtraction(a, b);
            case DIVIDE:
                return division(a, b);
            case RAISING_TO_THE_POWER:
                return raisingToBePower(a, b);
            default:
                throw new IllegalArgumentException("Wrong or don't exist signal");
        }
    }

    public static double additional(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double division(double a, double b) {
        if (a == ZERO_VALUE || b == ZERO_VALUE) {
            throw new ArithmeticException("Error! The value can't be zero!");
        }
        return a / b;
    }

    public static double multiplication(double a, double b) {
        if (a == ZERO_VALUE || b == ZERO_VALUE) {
            throw new ArithmeticException("Error! The value can't be zero!");
        }
        return a * b;
    }

    public static double raisingToBePower(double a, double b) {
        return Math.pow(a, b);
    }
}
