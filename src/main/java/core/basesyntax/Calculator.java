package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        double result;

        switch (operation) {
            case ADDITION:
                result = add(firstNumber, secondNumber);
                break;
            case SUBSTRACTION:
                result = substract(firstNumber, secondNumber);
                break;
            case DIVISION:
                result = divide(firstNumber, secondNumber);
                break;
            case MULTIPLICATION:
                result = miltiplicate(firstNumber, secondNumber);
                break;
            case RAISING_TO_POWER:
                result = raiseToPower(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }

        checkResultForOverflow(result);
        return result;
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
