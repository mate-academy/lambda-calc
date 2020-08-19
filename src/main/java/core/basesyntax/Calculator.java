package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public static double calculate(double number1, double number2, char action) {
        switch (action) {
            case ADDITION:
                return number1 + number2;
            case SUBTRACTION:
                return number1 - number2;
            case MULTIPLICATION:
                return number1 * number2;
            case DIVISION:
                return division(number1, number2);
            case POWER:
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
    }

    private static double division(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return number1 / number2;
    }
}
