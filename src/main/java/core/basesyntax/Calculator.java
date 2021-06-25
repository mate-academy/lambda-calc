package core.basesyntax;

public class Calculator {
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    private static final char DIVISION_SYMBOL = '/';
    private static final char TO_POWER_SYMBOL = '^';

    public double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case ADDITION_SYMBOL:
                return number1 + number2;
            case SUBTRACTION_SYMBOL:
                return number1 - number2;
            case MULTIPLICATION_SYMBOL:
                return number1 * number2;
            case DIVISION_SYMBOL:
                if (number2 == 0) {
                    throw new ArithmeticException("You're trying to divide by 0");
                }
                return number1 / number2;
            case TO_POWER_SYMBOL:
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("Not valid operation. Try again");
        }
    }
}
