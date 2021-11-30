package core.basesyntax;

public class Calculator {

    public double calculate(double x, double y, char operation) {
        double result;
        switch (operation) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return (result = x * y) == -0.0 ? 0 : result;
            case '/': if (y == 0) {
                    throw new IllegalArgumentException("Division by zero!");
                }
                return (result = x / y) == -0.0 ? 0 : result;
            case '^': return Math.pow(x, y);
            default: throw new UnsupportedOperationException("Illegal operation!");
        }
    }
}
