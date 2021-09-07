package core.basesyntax;

import java.util.NoSuchElementException;

public class Calculator {

    public double calculate(double x, double y, String operation) {
        if (operation.equals("+")) {
            return x + y;
        }
        if (operation.equals("-")) {
            return x - y;
        }
        if (operation.equals("*")) {
            return x * y;
        }
        if (operation.equals("/") && y != 0) {
            return x / y;
        }
        if (operation.equals("/") && y == 0) {
            throw new ArithmeticException("Can't divide by zero...");
        }
        if (operation.equals("^")) {
            return Math.pow(x, y);
        }
        throw new NoSuchElementException("Your data is incorrect...");
    }
}
