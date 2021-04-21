package core.basesyntax;

public class Calculator {
    private static final char ADDITION_ACTION = '+';
    private static final char SUBTRACTION_ACTION = '-';
    private static final char MULTIPLICATION_ACTION = '*';
    private static final char DIVISION_ACTION = '/';
    private static final char RAISING_ACTION = '^';

    public double calculate(double firstOperand, double secondOperand, char action) {
        switch (action) {
            case ADDITION_ACTION: {
                return firstOperand + secondOperand;
            }
            case SUBTRACTION_ACTION: {
                return firstOperand - secondOperand;
            }
            case MULTIPLICATION_ACTION: {
                return firstOperand * secondOperand;
            }
            case DIVISION_ACTION: {
                return firstOperand / secondOperand;
            }
            case RAISING_ACTION: {
                return Math.pow(firstOperand, secondOperand);
            }
            default: {
                throw new IllegalOperationException("This operation cannot be performed");
            }
        }
    }
}
