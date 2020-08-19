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

    private void checkResultForOverflow(double result) {
        if (result == Double.NEGATIVE_INFINITY
                || result == Double.POSITIVE_INFINITY
                || result == Double.MAX_VALUE
                || result == -Double.MAX_VALUE) {
            throw new ArithmeticException("Double overflow");
        }
    }

    private double add(double firstNumber, double secondNumber) {
        double result = firstNumber + secondNumber;
        checkResultForOverflow(result);
        return result;
    }

    private double substract(double firstNumber, double secondNumber) {
        double result = firstNumber - secondNumber;
        checkResultForOverflow(result);
        return result;
    }

    private double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("You can't divide by zero");
        }
        double result = firstNumber / secondNumber;
        checkResultForOverflow(result);
        return result;
    }

    private double miltiplicate(double firstNumber, double secondNumber) {
        double result = firstNumber * secondNumber;
        checkResultForOverflow(result);
        return result;
    }

    private double raiseToPower(double firstNumber, double secondNumber) {
        double result = Math.pow(firstNumber, secondNumber);
        checkResultForOverflow(result);
        return result;
    }
}
