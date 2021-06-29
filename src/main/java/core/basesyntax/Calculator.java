package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstArgument, double secondArgument, char operator) {
        switch (operator) {
            case PLUS:
                return firstArgument + secondArgument;
            case MINUS:
                return firstArgument - secondArgument;
            case DIVISION:
                if (secondArgument == 0) {
                    throw new ArithmeticException("Dividing by zero!");
                }
                return firstArgument / secondArgument;
            case MULTIPLICATION:
                return firstArgument * secondArgument;
            case POWER:
                return Math.pow(firstArgument, secondArgument);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operator);
        }
    }
}
