package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "p";
    private static final String POW_UPPERCASE = "P";

    public double calculate(int first, int second, String operation) {
        switch (operation) {
            case ADD:
                return (double) first + second;
            case SUB:
                return (double) first - second;
            case MUL:
                return (double) first * second;
            case DIV:
                if (second == 0) {
                    throw new ArithmeticException("Can't divide by 0");
                }
                return (double) first / second;
            case POW:
            case POW_UPPERCASE:
                return Math.pow(first, second);
            default:
                throw new RuntimeException("Invalid operation input! Was" + operation
                        + " but + - * / p expected");
        }
    }
}
