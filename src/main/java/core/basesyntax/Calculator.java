package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double first, double second, char sign) {
        switch (sign) {
            case PLUS:
                return first + second;
            case MINUS:
                return first - second;
            case MULTIPLICATION:
                return first * second;
            case DIVISION:
                if (second == 0) {
                    throw new ArithmeticException("We can't divide by zero");
                }
                return first / second;
            case POWER:
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("Unknown operation sign");
        }
    }
}
