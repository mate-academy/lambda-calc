package core.basesyntax;

public class Calculator {
    public double calculate(double first, double second, char operation) {
        if (operation == '+') {
            return first + second;
        }
        if (operation == '-') {
            return first - second;
        }
        if (operation == '/') {
            if (second == 0) {
                throw new ArithmeticException("You can't divide by zero");
            }
            return first / second;
        }
        if (operation == '*') {
            return first * second;
        }
        if (operation == '^') {
            return Math.pow(first, second);
        }
        throw new RuntimeException("Unknown operation " + operation);
    }
}
