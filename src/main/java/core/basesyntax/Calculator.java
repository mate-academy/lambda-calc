package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b != 0) {
                    return a / b;
                }
                throw new ArithmeticException("Divide by 0");
            case RAISING:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unexpected argument: " + operation);
        }
    }
}
