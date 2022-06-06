package core.basesyntax;

public class Calculator {
    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '^':
                return Math.pow(first, second);
            case '/':
                if (second == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                return first / second;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
