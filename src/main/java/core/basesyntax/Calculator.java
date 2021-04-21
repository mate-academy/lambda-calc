package core.basesyntax;

public class Calculator {
    public double calculate(double first, double second, char operation) {
        if (operation == '+') {
            return first + second;
        }
        if (operation == '-') {
            return first - second;
        }
        if (operation == '*') {
            return first * second;
        }
        if (operation == '/') {
            if (second == 0) {
                throw new ArithmeticException("Not possible divide to zero");
            } else {
                return first / second;
            }
        }
        if (operation == '^') {
            return Math.pow(first, second);
        }
        throw new RuntimeException("Incorrect arithmetic operation");
    }
}
