package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final char SUBTRACT = '-';
    private static final char DIVIDE = '/';
    private static final char RAISING_TO_THE_POWER = '^';

    public double calculate(double a, double b, char signal) {
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

    private double additional(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double division(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Error! 'b' can't be zero! 'B' value: " + b);
        }
        return a / b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double raisingToBePower(double a, double b) {
        return Math.pow(a, b);
    }
}
