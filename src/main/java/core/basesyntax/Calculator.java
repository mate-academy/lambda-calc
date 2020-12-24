package core.basesyntax;

import java.util.NoSuchElementException;

public class Calculator {
    public double calculate(int number1, int number2, char operation) {
        switch (operation) {
            case '+':
                return operationAddition(number1, number2);
            case '-':
                return operationSubtraction(number1, number2);
            case '/':
                return operationDivision(number1, number2);
            case '*':
                return operationMultiplication(number1, number2);
            case '^':
                return operationRaisingToAPower(number1, number2);
            default:
                throw new NoSuchElementException("Didn't find operation: " + operation);
        }
    }

    private double operationAddition(int number1, int number2) {
        return number1 + number2;
    }

    private double operationSubtraction(int number1, int number2) {
        return number1 - number2;
    }

    private double operationDivision(int number1, int number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("We can't divide on 0");
        }
        double result = (double) number1 / number2;
        double scale = Math.pow(10, 2);
        return Math.round(result * scale) / scale;
    }

    private double operationMultiplication(int number1, int number2) {
        return number1 * number2;
    }

    private double operationRaisingToAPower(int number1, int number2) {
        if (number2 == 0 && number1 < 0) {
            return -1;
        }

        if (number1 < 0) {
            throw new IllegalArgumentException("We can't get raising to a power for "
                    + "negative number");
        }
        double result = Math.pow(number1, number2);
        double scale = Math.pow(10, 3);
        return Math.round(result * scale) / scale;
    }
}
