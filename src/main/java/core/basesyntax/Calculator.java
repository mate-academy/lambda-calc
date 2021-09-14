package core.basesyntax;

public class Calculator {
    private static final char PLUS_SIGN = '+';
    private static final char MINUS_SIGN = '-';
    private static final char MULTIPLY_SIGN = '*';
    private static final char DIVIDE_SIGN = '/';
    private static final char RAISING_SIGN = '^';

    double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case PLUS_SIGN:
                return firstValue + secondValue;
            case MINUS_SIGN:
                return firstValue - secondValue;
            case MULTIPLY_SIGN:
                return firstValue * secondValue;
            case DIVIDE_SIGN:
                if (secondValue == 0) {
                    throw new ArithmeticException("Division by zero is forbidden");
                }
                return firstValue / secondValue;
            case RAISING_SIGN:
                return Math.pow(firstValue,secondValue);
            default:
                throw new IllegalArgumentException("Argument is illegal");
        }
    }
}
