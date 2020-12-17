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

    /*
    + second adds to first
    - second subtracts from fist
    / first is divisor and second is divider
    * second times first
    p first in the power of second
     */
    public double calculate(int first, int second, String operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        if (operation.equals(ADD)) {
            return (double) first + second;
        }
        if (operation.equals(SUB)) {
            return (double) first - second;
        }
        if (operation.equals(DIV)) {
            if (second == 0) {
                throw new ArithmeticException("Can't divide by 0");
            }
            return (double) first / second;
        }
        if (operation.equals(MUL)) {
            return (double) first * second;
        }
        if (operation.equals(POW) || operation.equals(POW.toUpperCase())) {
            return Math.pow(first, second);
        }
        throw new RuntimeException("Invalid operation input! Was" + operation
        + " but + - * / p expected");
    }
}
