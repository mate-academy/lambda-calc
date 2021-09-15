package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    public double calculate(double firstValue, double secondValue, char operation)
            throws ValidationException {
        switch (operation) {
            case ADDITION:
                return firstValue + secondValue;
            case SUBTRACTION:
                return firstValue - secondValue;
            case MULTIPLICATION:
                return firstValue * secondValue;
            case DIVISION:
                if (secondValue == 0) {
                    throw new ArithmeticException("Can't divide by 0");
                }
                return firstValue / secondValue;
            case RAISING_TO_A_POWER:
                return Math.pow(firstValue, secondValue);
            default:
                throw new ValidationException("The input operation is incorrect");
        }

    }
}
