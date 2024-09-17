package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("You can't divide by zero!");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
