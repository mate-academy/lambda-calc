package core.basesyntax;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double first, double second, char action) {
        if (first == Double.POSITIVE_INFINITY
                || second == Double.POSITIVE_INFINITY) {
            throw new RuntimeException("input numbers cant be Infinity");
        }
        if ((second == 0) && action == '/') {
            throw new ArithmeticException("division by zero");
        }
        switch (action) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second == -0 ? 0 : first * second;
            case '/': return first / second == -0 ? 0 : first / second;
            case '^': return Math.pow(first, second);
            default: throw new RuntimeException("input right action");
        }
    }
}
