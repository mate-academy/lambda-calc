package core.basesyntax;

public class Calculator {
    public double calculate(int first, int second, char operator) {
        switch (operator) {
            case '+':
                return (double) first + second;
            case '-':
                return (double) first - second;
            case '*':
                return (double) first * second;
            case '/':
                if (second == 0) {
                    throw new ArithmeticException("NaN: you cannot divide by zero");
                }
                return (double) first / second;
            case '^':
                return Math.pow(first, second);
            default:
                throw new InvalidOperationException("Operation not supported");
        }
    }
}
