package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    private static final double NAN = Double.NaN;

    @Override
    public double calculate(double first, double second, char action) {
        if ((first == NAN || second == NAN) || (first == POSITIVE_INFINITY
                || second == POSITIVE_INFINITY)) {
            throw new RuntimeException("input numbers cant be NaN or Infinity");
        }
        if ((first == 0 || second == 0) && action == '/') {
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
