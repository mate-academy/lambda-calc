package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) {
        if (operation == '^') {
            return Math.pow(a, b);
        }
        if (operation == '+') {
            return a + b;
        }
        if (operation == '-') {
            return a - b;
        }
        if (operation == '*') {
            return a * b;
        }
        if (operation == '/') {
            if (b == 0) {
                throw new ArithmeticException("You can`t divide by zero");
            }
            return a / b;
        }
        throw new RuntimeException("Invalid operation" + operation);
    }
}
