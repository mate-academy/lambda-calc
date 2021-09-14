package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                if (b == 0) {
                    throw new RuntimeException("Error, division by 0");
                }
                return a / b;
            case '*':
                return a * b;
            case '^':
                if (a < 0 && b != (long) b) {
                    throw new RuntimeException("Error");
                }
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Error, unknown operation type");
        }
    }
}
