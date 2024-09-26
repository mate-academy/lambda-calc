package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';

    public double calculate(double operandA, double operandB, char operation)
            throws ValidationException {
        switch (operation) {
            case ADDITION:
                return operandA + operandB;
            case SUBTRACTION:
                return operandA - operandB;
            case MULTIPLICATION:
                return operandA * operandB;
            case DIVISION:
                if (operandB == 0) {
                    throw new ArithmeticException("/ by zero");
                }
                return operandA / operandB;
            case RAISING_TO_POWER:
                return Math.pow(operandA, operandB);
            default:
                throw new ValidationException("Incorrect operation");
        }

    }
}
