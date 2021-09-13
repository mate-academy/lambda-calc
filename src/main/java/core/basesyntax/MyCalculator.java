package core.basesyntax;

public class MyCalculator implements Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';
    public static final char MULTIPLICATION = '*';
    public static final char RISING_TO_POWER = '^';

    @Override
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case ADDITION :
                return firstValue + secondValue;
            case SUBTRACTION :
                return firstValue - secondValue;
            case DIVISION :
                if (secondValue == 0) {
                    throw new ArithmeticException("Second value can't be 0!");
                }
                return firstValue / secondValue;
            case MULTIPLICATION :
                return firstValue * secondValue;
            case RISING_TO_POWER :
                return Math.pow(firstValue, secondValue);
            default:
                throw new UnknownOperationException("Unknown operation");
        }
    }
}
