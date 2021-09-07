package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstValue, double secondValue, char operation) {
        if (Character.toString(operation).matches("[^\\+\\-\\*\\/\\^]")) {
            throw new IllegalOperation("Illegal Parameter");
        }
        switch (operation) {
            case ADDITION:
                checkBigResult(firstValue + secondValue);
                return firstValue + secondValue;
            case SUBTRACTION:
                checkBigResult(firstValue - secondValue);
                return firstValue - secondValue;
            case MULTIPLICATION:
                checkBigResult(firstValue * secondValue);
                return firstValue * secondValue;
            case DIVISION:
                if (secondValue == 0.0) {
                    throw new DivisionByZero("Division by zero");
                }
                checkBigResult(firstValue / secondValue);
                return firstValue / secondValue;
            case POWER:
                if (firstValue < 0
                        && secondValue != 0.0
                        && secondValue < 1
                        && secondValue > -1) {
                    throw new IllegalValues("Illegal root of Negative value");
                }
                checkBigResult(Math.pow(firstValue, secondValue));
                return Math.pow(firstValue, secondValue);
            default:
                return 0.0;
        }
    }

    private void checkBigResult(double result) {
        if (result == Double.POSITIVE_INFINITY
                || result == Double.NEGATIVE_INFINITY) {
            throw new IllegalValues("We have very big result");
        }
    }
}
