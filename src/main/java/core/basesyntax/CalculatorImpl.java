package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Divide by zero";
    private static final String INVALID_OPERATION_MESSAGE = "Operation is not valid";
    private static final String VALUES_TOO_BIG_MESSAGE = "Numbers are too big";

    @Override
    public double calculate(double firstNumber, char operation, double secondNumber) {
        if (operation == '+') {
            if (Math.abs(firstNumber + secondNumber) >= Double.MAX_VALUE) {
                throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
            }
            return firstNumber + secondNumber;
        } else if (operation == '-') {
            if (Math.abs(firstNumber - secondNumber) >= Double.MAX_VALUE) {
                throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
            }
            return firstNumber - secondNumber;
        } else if (operation == '/') {
            if (secondNumber == 0) {
                throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);
            }
            return firstNumber / secondNumber;
        } else if (operation == '*') {
            if (Math.abs(firstNumber * secondNumber) >= Double.MAX_VALUE) {
                throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
            }
            return firstNumber * secondNumber;
        } else if (operation == '^') {
            if (Math.abs(Math.pow(firstNumber, secondNumber)) >= Double.MAX_VALUE) {
                throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
            }
            return Math.pow(firstNumber, secondNumber);
        } else {
            throw new InvalidOperationException(INVALID_OPERATION_MESSAGE);
        }
    }
}
