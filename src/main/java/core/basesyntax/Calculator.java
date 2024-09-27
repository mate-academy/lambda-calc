package core.basesyntax;

public class Calculator {

    public static double calculate(double a, double b, char operation) {
        if (operation == '+') {
            return a + b;
        }
        if (operation == '-') {
            return a - b;
        }
        if (operation == '/') {
            if (b == 0) {
                throw new ArithmeticException("You can't divided by zero");
            }
            return a / b;
        }
        if (operation == '*') {
            return a * b;
        }
        if (operation == '^') {
            return Math.pow(a, b);
        }
        throw new IllegalArgumentException("There is no such operation here!");
    }
}

