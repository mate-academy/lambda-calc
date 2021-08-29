package core.basesyntax;

public class SimpleCalculator implements Calculator {
    @Override
    public double calculate(double a, double b, char operand) {
        if (operand == '+') {
            return a + b;
        } else if (operand == '-') {
            return a - b;
        } else if (operand == '/') {
            if (b == 0) {
                throw new ArithmeticException();
            }
            if (a == Double.MAX_VALUE && b == Double.MIN_VALUE) {
                throw new ArithmeticException();
            }
            return a / b;
        } else if (operand == '*') {
            return a * b;
        } else if (operand == '^') {
            return Math.pow(a, b);
        } else {
            throw new RuntimeException("This operation cannot be processed");
        }
    }
}
