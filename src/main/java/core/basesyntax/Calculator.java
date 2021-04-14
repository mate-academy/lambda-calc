package core.basesyntax;

import core.basesyntax.exception.InvalidOperatorException;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISE_TO_POWER = '^';

    public double calculate(double leftOperand, double rightOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return leftOperand + rightOperand;
            case SUBTRACTION:
                return leftOperand - rightOperand;
            case DIVISION:
                if (rightOperand == 0) {
                    throw new ArithmeticException("Can not divide by zero");
                } else {
                    return leftOperand / rightOperand;
                }
            case MULTIPLICATION:
                return leftOperand * rightOperand;
            case RAISE_TO_POWER:
                return Math.pow(leftOperand, rightOperand);
            default:
                throw new InvalidOperatorException("Invalid operator");

        }
    }
}
