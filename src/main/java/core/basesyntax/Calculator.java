package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';

    public double calculate(double value1, double value2, char operation) {
        switch (operation) {
            case MINUS:
                return value1 - value2;
            case PLUS:
                return value1 + value2;
            case MULTIPLY:
                return value1 * value2;
            case DIVIDE:
                if (value2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return value1 / value2;
            case POWER:
                return Math.pow(value1, value2);
            default:
                throw new RuntimeException("No operation with '" + operation + "'.");
        }
    }
}
