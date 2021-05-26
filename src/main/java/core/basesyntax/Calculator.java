package core.basesyntax;

public class Calculator {
    private final static char PLUS_OPERATION = '+';
    private final static char MINUS_OPERATION = '-';
    private final static char MULTIPLE_OPERATION = '*';
    private final static char DIVIDE_OPERATION = '/';
    private final static char RAISING_OPERATION = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case PLUS_OPERATION:
                return firstNumber + secondNumber;
            case MINUS_OPERATION:
                return firstNumber - secondNumber;
            case MULTIPLE_OPERATION:
                return firstNumber * secondNumber;
            case DIVIDE_OPERATION:
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("Divide on zero unavailable");
                }

                return firstNumber / secondNumber;
            case RAISING_OPERATION:
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("You can use only /, *, +, -");
        }
    }
}
