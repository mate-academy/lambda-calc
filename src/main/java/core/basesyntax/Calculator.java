package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    public double calculate(double a, double b, char operation) throws ValidationException {
        switch (operation) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Can't divide by 0");
                }
                return a / b;
            case RAISING_TO_A_POWER:
                return Math.pow(a, b);
            default:
                throw new ValidationException("The input operation is incorrect");
        }

    }
}
