package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String POW = "^";

    public double calculate(int a, int b, String operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        switch (operation) {
            case ADDITION:
                return (double) a + b;
            case SUBTRACTION:
                return (double) a - b;
            case MULTIPLICATION:
                return (double) a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Division by 0!");
                }
                return (double) a / b;
            case POW:
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Input correct operation! Expected '+', '-', '*',"
                        + "'/' and '^', but was " + operation);
        }
    }
}
