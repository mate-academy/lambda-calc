package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                return firstOperand / secondOperand;
            case POWER:
                if (firstOperand == 0 && secondOperand < 0) {
                    throw new ArithmeticException("Zero can't have negative power!");
                }
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("This operation is unsupported!");
        }
    }
}
