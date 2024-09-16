package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operator) {
        double result;
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;

            case '^':
                return Math.pow(a, b);

            default:
                throw new IllegalOperationException("Bad operator or operation is not supported");
        }
    }

}
