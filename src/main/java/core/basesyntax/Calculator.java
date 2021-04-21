package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/' :
                if (b == 0) {
                    throw new ArithmeticException("/ by zero");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new UnsupportedOperationException("This operator is not supported: "
                        + operator);
        }
    }
}
