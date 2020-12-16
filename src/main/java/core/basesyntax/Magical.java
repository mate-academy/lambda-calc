package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Magical {
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
        if (operation == "+") {
            return (double) first + second;
        }
        if (operation == "-") {
            return (double) first - second;
        }
        if (operation == "/") {
            if (second == 0) {
                throw new ArithmeticException("Can't divide bu 0");
            }
            return (double) first / second;
        }
        if (operation == "*") {
            return (double) first * second;
        }
        if (operation == "p") {
            return Math.pow(first, second);
        }
        throw new RuntimeException("Invalid operation input! Was" + operation
        + " but + - * / p expected");
    }
}
