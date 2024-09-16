package core.basesyntax;

public class Calculator implements BigCalculator {
    public double calculate(double a, double b, char operation) {
        if (operation == '+') {
            return a + b;
        }
        if (operation == '-') {
            return a - b;
        }
        if (operation == '/' && b == 0) {
            throw new ArithmeticException("Division by zero.");
        }
        if (operation == '/' && b != 0) {
            return a / b;
        }
        if (operation == '*') {
            return a * b;
        }
        if (operation == '^') {
            return Math.pow(a, b);
        }
        throw new IllegalArgumentException("Illegal argument operation");
    }
}
