package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVIDING = '/';
    private static final char RAISING_TO_POWER = '^';

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case ADDITION:
                return first + second;
            case SUBTRACTION:
                return first - second;
            case DIVIDING:
                if (second == 0) {
                    throw new ArithmeticException("/ by zero");
                }
                return first / second;
            case MULTIPLICATION:
                return first * second;
            case RAISING_TO_POWER:
                return Math.pow(first, second);
            default :
                throw new RuntimeException("Unknown operation");
        }
    }
}
