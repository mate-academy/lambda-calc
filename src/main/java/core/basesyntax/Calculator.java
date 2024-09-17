package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case PLUS:
                return firstOperand + secondOperand;
            case MINUS:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand == 0) {
                    throw new ArithmeticException("Divide by zero is unavailable");
                }
                return firstOperand / secondOperand;
            case POWER:
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("This is unknown operation!");
        }
    }
}
