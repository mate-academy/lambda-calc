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
            case '/':
                if (second == 0) {
                    throw new ArithmeticException("Not possible divide to zero");
                } else {
                    return first / second;
                }
            case '^':
                return first < 0 && second == 0 ? -Math.pow(first, second)
                        : Math.pow(first, second);
            default:
                throw new RuntimeException("Incorrect arithmetic operation");
        }
    }
}
