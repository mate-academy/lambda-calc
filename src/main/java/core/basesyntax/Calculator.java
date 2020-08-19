package core.basesyntax;

public class Calculator {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MULT = '*';
    private static final char POW = '^';
    private static final double ZERO = 0.0;

    public double calculate(double firstOperand, char operator, double secondOperand) {
        switch (operator) {
            case ADD:
                return firstOperand + secondOperand;
            case SUB:
                return firstOperand - secondOperand;
            case DIV:
                if (secondOperand == ZERO) {
                    throw new ArithmeticException("Cannot divide by 0");
                }
                return firstOperand / secondOperand;
            case MULT:
                return firstOperand * secondOperand;
            case POW:
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("Unsupported operator");
        }
    }
}
