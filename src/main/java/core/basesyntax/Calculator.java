package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER_RAISING = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case ADDITION:
                return addition(firstNumber, secondNumber);
            case SUBTRACTION:
                return subtraction(firstNumber, secondNumber);
            case DIVISION:
                return division(firstNumber, secondNumber);
            case MULTIPLICATION:
                return multiplication(firstNumber, secondNumber);
            case POWER_RAISING:
                return powerRaising(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("No such action in calculator");
        }
    }

    private double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return firstNumber / secondNumber;
    }

    private double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double powerRaising(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
