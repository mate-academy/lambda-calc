package core.basesyntax;

import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final Map<Character, DoubleBinaryOperator> OPERATIONS = Map.of(
            '+', Double::sum,
            '-', (double x, double y) -> x - y,
            '*', (double x, double y) -> x * y,
            '/', (double x, double y) -> x / y,
            '^', Math::pow);

    public double calculate(double x, double y, char operation) {
        if (!OPERATIONS.containsKey(operation)) {
            throw new IllegalArgumentException("Illegal operation");
        }
        if (operation == '/' && y == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        if (operation == '^' && x < 0 && y > 0 && y < 1) {
            throw new IllegalArgumentException("Extracting a root of a negative number");
        }
        return OPERATIONS.get(operation).applyAsDouble(x, y);
    }
}
