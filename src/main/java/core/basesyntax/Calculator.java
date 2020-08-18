package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLE = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final double DELTA = 0.000_001;

    public double calculate(double a, double b, char sign) {
        switch (sign) {
            case PLUS:
                return addition(a, b);
            case MINUS:
                return subtraction(a, b);
            case MULTIPLE:
                return multiplication(a, b);
            case DIVISION:
                return division(a, b);
            case POWER:
                return power(a, b);
            default:
                throw new IllegalArgumentException("Wrong sign");
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
        if (Math.abs(b) < DELTA) {
            throw new IllegalArgumentException("Can't div by zero");
        }
        return a / b;
    }

    private double power(double a, double b) {
        return Math.pow(a, b);
    }
}
