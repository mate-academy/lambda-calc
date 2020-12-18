package core.basesyntax;

public class Calculator {
    public double calculate(double x, char operation, double y) {
        switch (operation) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                if (y == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return x / y;
            case '^':
                return Math.pow(x, y);
            default:
                throw new ArithmeticException("Invalid math operator");
        }
    }
}
