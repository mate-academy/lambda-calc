package core.basesyntax;

public class Calculator {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLE = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final String DIVIDE_BY_ZERO = "Divide by zero";
    private static final String UNKNOWN_OPERAND = "Unknown operand";

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLE:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException(DIVIDE_BY_ZERO);
                }
                return a / b;
            case POW:
                return Math.pow(a, b);
            default:
                throw new UnsupportedOperationException(UNKNOWN_OPERAND);
        }
    }
}
