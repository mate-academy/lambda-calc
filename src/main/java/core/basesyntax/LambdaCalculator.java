package core.basesyntax;

public class LambdaCalculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double number1, double number2, char operator) {
        switch (operator) {
            case PLUS:
                return number1 + number2;
            case MINUS:
                return number1 - number2;
            case DIVISION:
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by ZERO");
                }
                return number1 / number2;
            case MULTIPLY:
                return number1 * number2;
            case POWER:
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("Wrong operator type");
        }
    }
}
