package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    public double calculator(double value1, double value2, char operation) {
        switch (operation) {
            case ADDITION:
                return addition(value1, value2);
            case SUBTRACTION:
                return subtraction(value1, value2);
            case DIVISION:
                return division(value1, value2);
            case MULTIPLICATION:
                return multiplication(value1, value2);
            case POWER:
                return power(value1, value2);
            default:
                throw new IllegalArgumentException("Operation with "
                        + operation + "is not supported");
        }
    }

    private static double addition(double value1, double value2) {
        return value1 + value2;
    }

    private static double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    private static double division(double value1, double value2) {
        if (value2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return value1 / value2;
    }

    private static double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    private static double power(double value1, double value2) {
        return Math.pow(value1, value2);
    }
}
