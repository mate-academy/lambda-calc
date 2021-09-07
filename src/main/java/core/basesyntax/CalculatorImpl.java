package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Divide by zero";
    private static final String INVALID_OPERATION_MESSAGE = "Operation is not valid";

    @Override
    public double calculate(double firstNumber, char operation, double secondNumber) {
        if (operation == '+') {
            return firstNumber + secondNumber;
        } else if (operation == '-') {
            return firstNumber - secondNumber;
        } else if (operation == '/') {
            if (secondNumber == 0) {
                throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);
            }
            return firstNumber / secondNumber;
        } else if (operation == '*') {
            return firstNumber * secondNumber;
        } else if (operation == '^') {
            return power(firstNumber, secondNumber);
        } else {
            throw new InvalidOperationException(INVALID_OPERATION_MESSAGE);
        }
    }

    private double power(double firstNumber, double secondNumber) {
        double result = 1;
        if (secondNumber >= 0) {
            for (int i = 0; i < (int) secondNumber; i++) {
                result *= firstNumber;
            }
        } else {
            if (firstNumber == 0) {
                return 0;
            }
            for (int i = 0; i < (-1 * (int) secondNumber); i++) {
                result /= firstNumber;
            }
        }
        return result;
    }
}
