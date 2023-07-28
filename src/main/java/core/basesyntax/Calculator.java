package core.basesyntax;

public class Calculator {
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    private static final char DIVISION_SYMBOL = '/';
    private static final char TO_POWER_SYMBOL = '^';

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case ADDITION_SYMBOL:
                return first + second;
            case SUBTRACTION_SYMBOL:
                return first - second;
            case MULTIPLICATION_SYMBOL:
                return first * second;
            case DIVISION_SYMBOL:
                if (second == 0) {
                    throw new ArithmeticException("You're trying to divide by 0");
                }
                return first / second;
            case TO_POWER_SYMBOL:
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("Not valid operation. Try again");
        }
    }
}
