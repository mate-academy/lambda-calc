package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    public double calculator(double value1, double value2, char operation) {
        double result;
        switch (operation) {
            case ADDITION:
                result = addition(value1, value2);
                isInfinity(result);
                return result;
            case SUBTRACTION:
                result = subtraction(value1, value2);
                isInfinity(result);
                return result;
            case DIVISION:
                result = division(value1, value2);
                isInfinity(result);
                return result;
            case MULTIPLICATION:
                result = multiplication(value1, value2);
                isInfinity(result);
                return result;
            case POWER:
                result = power(value1, value2);
                isInfinity(result);
                return result;
            default:
                throw new IllegalArgumentException("Operation with "
                        + operation + "is not supported");
        }
    }

    private double addition(double value1, double value2) {
        return value1 + value2;
    }

    private double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    private double division(double value1, double value2) {
        if (value2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return value1 / value2;
    }

    private double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    private double power(double value1, double value2) {
        return Math.pow(value1, value2);
    }

    private void isInfinity(double result) {
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Double overflow");
        }
    }
}
