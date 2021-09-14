package core.basesyntax;

public class Calculator {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char RAISING_TO_POWER_OPERATOR = '^';

    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case ADDITION_OPERATOR:
                return firstValue + secondValue;
            case SUBTRACTION_OPERATOR:
                return firstValue - secondValue;
            case MULTIPLICATION_OPERATOR:
                return firstValue * secondValue;
            case DIVISION_OPERATOR:
                if (secondValue == 0) {
                    throw new ArithmeticException("can`t divide on 0");
                }
                return firstValue / secondValue;
            case RAISING_TO_POWER_OPERATOR:
                if (firstValue < 0 && secondValue == Double.MIN_VALUE) {
                    throw new IllegalValueException("can`t resolve operation");
                }
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalOperatorException("can't recognise operator, try again");
        }
    }
}
