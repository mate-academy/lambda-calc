package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RISING_TO_POWER = '^';

    public double calculate(double value1, double value2, char operation) {
        if (operation == ADDITION) {
            return value1 + value2;
        }

        if (operation == SUBTRACTION) {
            return value1 - value2;
        }

        if (operation == DIVISION) {
            if (value2 == 0) {
                throw new ArithmeticException("Can't divide by zero");
            }
            return value1 / value2;
        }

        if (operation == MULTIPLICATION) {
            return value1 * value2;
        }

        if (operation == RISING_TO_POWER) {
            return Math.pow(value1, value2);
        }
        throw new IllegalArgumentException("Unknown operation sign");
    }
}
