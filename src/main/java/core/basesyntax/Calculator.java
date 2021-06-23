package core.basesyntax;

public class Calculator {
    private static final char ADDITION_OPERATION = '+';
    private static final char SUBTRACTION_OPERATION = '-';
    private static final char DIVISION_OPERATION = '/';
    private static final char MULTIPLICATION_OPERATION = '*';
    private static final char RAISING_TO_A_POWER_OPERATION = '^';

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case ADDITION_OPERATION:
                return first + second;
            case SUBTRACTION_OPERATION:
                return first - second;
            case DIVISION_OPERATION:
                if (second == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return first / second;
            case MULTIPLICATION_OPERATION:
                return first * second;
            case RAISING_TO_A_POWER_OPERATION:
                return Math.pow(first, second);
            default:
                throw new IllegalArgumentException("No such operation: " + operation + " !");
        }
    }
}
