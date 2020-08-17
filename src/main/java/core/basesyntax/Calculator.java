package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static final Map<Character, DoubleBinaryOperator> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put('+', (x, y) -> x + y);
        OPERATIONS.put('-', (x, y) -> x - y);
        OPERATIONS.put('*', (x, y) -> x * y);
        OPERATIONS.put('/', (x, y) -> x / y);
        OPERATIONS.put('^', Math::pow);
    }

    public static double calculate(double x, double y, char operation) {
        DoubleBinaryOperator doubleBinaryOperator = OPERATIONS.get(operation);
        if (doubleBinaryOperator == null) {
            throw new IllegalArgumentException();
        }
        return doubleBinaryOperator.applyAsDouble(x, y);
    }
}
