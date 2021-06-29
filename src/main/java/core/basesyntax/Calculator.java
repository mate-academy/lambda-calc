package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';

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
                    throw new ArithmeticException("Cant divide by zero!");
                }
                return firstOperand / secondOperand;
            case RAISING:
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new NoSuchOperationException("Operation is unknown!");
        }
    }
}
