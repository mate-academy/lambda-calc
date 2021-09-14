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
                return checkResult(firstNumber + secondNumber);
            case SUBTRACTION:
                return checkResult(firstNumber - secondNumber);
            case MULTIPLICATION:
                return checkResult(firstNumber * secondNumber);
            case DIVISION:
                if (secondNumber == 0) {
                    throw new OperationTypeException("You can't divide by zero");
                }
                return checkResult(firstNumber / secondNumber);
            case RAISING_TO_A_POWER:
                return checkResult(Math.pow(firstNumber, secondNumber));
            default:
                throw new OperationTypeException("This type of operation is not supported");
        }
    }

    private double checkResult(double result) {
        if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
            throw new OperationTypeException("Too large or small value");
        }
        return result;
    }
}
