package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Divide by zero";
    private static final String INVALID_OPERATION_MESSAGE = "Operation is not valid";
    private static final String VALUES_TOO_BIG_MESSAGE = "Numbers are too big";

    @Override
    public double calculate(double firstNumber, char operation, double secondNumber) {
        switch (operation) {
            case '+':
                return addition(firstNumber, secondNumber);
            case '-':
                return subtraction(firstNumber, secondNumber);
            case '/':
                return division(firstNumber, secondNumber);
            case '*':
                return multiplication(firstNumber, secondNumber);
            case '^':
                return power(firstNumber, secondNumber);
            default:
                throw new InvalidOperationException(INVALID_OPERATION_MESSAGE);
        }
    }

    private double addition(double firstNumber, double secondNumber) {
        if (Math.abs(firstNumber + secondNumber) >= Double.MAX_VALUE) {
            throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
        }
        return firstNumber + secondNumber;
    }

    private double subtraction(double firstNumber, double secondNumber) {
        if (Math.abs(firstNumber - secondNumber) >= Double.MAX_VALUE) {
            throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
        }
        return firstNumber - secondNumber;
    }

    private double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);
        }
        return firstNumber / secondNumber;
    }

    private double multiplication(double firstNumber, double secondNumber) {
        if (Math.abs(firstNumber * secondNumber) >= Double.MAX_VALUE) {
            throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
        }
        return firstNumber * secondNumber;
    }

    private double power(double firstNumber, double secondNumber) {
        if (Math.abs(Math.pow(firstNumber, secondNumber)) >= Double.MAX_VALUE) {
            throw new TooBigValuesException(VALUES_TOO_BIG_MESSAGE);
        }
        return Math.pow(firstNumber, secondNumber);
    }
}
