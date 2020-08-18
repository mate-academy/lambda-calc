package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char DIVISION_SIGN = '/';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char RAISING_TO_THE_POWER_SIGN = '^';

    public double calculate(Double firstValue, char operation, Double secondValue) {
        switch (operation) {
            case ADDITION_SIGN:
                return firstValue + secondValue;
            case SUBTRACTION_SIGN:
                return firstValue - secondValue;
            case MULTIPLICATION_SIGN:
                return firstValue * secondValue;
            case DIVISION_SIGN:
                return firstValue / secondValue;
            case RAISING_TO_THE_POWER_SIGN:
                return Math.pow(firstValue, secondValue);
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
    }
}
