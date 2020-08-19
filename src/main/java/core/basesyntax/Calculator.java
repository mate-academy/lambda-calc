package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case ADDITION:
                return add(firstNumber, secondNumber);
            case SUBSTRACTION:
                return substract(firstNumber, secondNumber);
            case DIVISION:
                return divide(firstNumber, secondNumber);
            case MULTIPLICATION:
                return miltiplicate(firstNumber, secondNumber);
            case RAISING_TO_POWER:
                return raiseToPower(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }

    private double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double substract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("You can't divide by zero");
        }
        return firstNumber / secondNumber;
    }

    private double miltiplicate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double raiseToPower(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
