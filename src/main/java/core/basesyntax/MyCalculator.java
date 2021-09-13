package core.basesyntax;

public class MyCalculator implements Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    @Override
    public double calculate(double firstNumber, char operationType, double secondNumber) {
        switch (operationType) {
            case ADDITION:
                return firstNumber + secondNumber;
            case SUBTRACTION:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                if (secondNumber == 0) {
                    throw new OperationTypeException("You can't divide by zero");
                }
                return firstNumber / secondNumber;
            case RAISING_TO_A_POWER:
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new OperationTypeException("This type of operation is not supported");
        }
    }
}
