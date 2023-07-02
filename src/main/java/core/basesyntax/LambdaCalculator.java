package core.basesyntax;

public class LambdaCalculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case DIVISION:
                if (secondNumber == 0) {
                    throw new ArithmeticException("Can't divide by ZERO");
                }
                return firstNumber / secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case POWER:
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Wrong operator type");
        }
    }
}
