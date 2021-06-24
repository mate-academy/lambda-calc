package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_IN_POWER = '^';

    @Override
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case ADDITION:
                return firstValue + secondValue;
            case SUBTRACTION:
                return firstValue - secondValue;
            case MULTIPLICATION:
                return firstValue * secondValue;
            case DIVISION:
                if (secondValue == 0) {
                    throw new ArithmeticException("Division by 0 is impossible!");
                }
                return firstValue / secondValue;
            case RAISING_IN_POWER:
                return Math.pow(firstValue, secondValue);
            default:
                throw new OperationNonValidException("This is unknown operation!");
        }
    }
}
