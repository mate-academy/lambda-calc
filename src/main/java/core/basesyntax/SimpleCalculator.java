package core.basesyntax;

public class SimpleCalculator implements Calculator {
    @Override
    public double calculate(double a, double b, char operand) {
        switch (operand) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException();
                }
                if (a == Double.MAX_VALUE && b == Double.MIN_VALUE) {
                    throw new ArithmeticException();
                }
                return a / b;
            case '*':
                return a * b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new RuntimeException("This operation cannot be processed " + operand);
        }
    }
}
