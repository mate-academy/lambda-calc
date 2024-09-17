package core.basesyntax;

public class LambdaCalculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case ADDITION:
                return firstNumber + secondNumber;
            case SUBTRACTION:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is prohibited!");
                }
                return firstNumber / secondNumber;
            case POWER:
                if (firstNumber == 0 && secondNumber < 0) {
                    throw new ArithmeticException("Zero can't power to a negative degree!");
                }
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Operation don't exist!");
        }
    }
}
