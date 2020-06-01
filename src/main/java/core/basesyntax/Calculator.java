package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final HashMap<Character, DoubleBinaryOperator> OPERATIONS;

    static {
        OPERATIONS = new HashMap<>();
        OPERATIONS.put('+', (Double::sum));
        OPERATIONS.put('-', (a, b) -> a - b);
        OPERATIONS.put('*', (a, b) -> a * b);
        OPERATIONS.put('/', (a, b) -> a / b);
        OPERATIONS.put('^', Math::pow);
    }

    public double calculate(double a, double b, char operator) {
        return OPERATIONS.get(operator).applyAsDouble(a, b);
    }
}
