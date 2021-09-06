package core.basesyntax;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double first, double second, char action) {
        if ((first == NaN || second == NaN) || (first == POSITIVE_INFINITY || second == POSITIVE_INFINITY)) {
            throw new RuntimeException("input numbers cant be NaN or Infinity");
        }
        if ((first == 0 || second == 0) && action == '/') {
            throw new ArithmeticException("division by zero");
        }
        switch (action) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second == -0? 0: first * second;
            case '/': return first / second == -0? 0: first / second;
            case '^': return Math.pow(first, second);
            default: throw new RuntimeException("input right action");
        }
    }
}
