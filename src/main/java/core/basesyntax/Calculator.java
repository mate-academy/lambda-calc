package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final HashMap<Character, DoubleBinaryOperator> operations;

    public double calculation(double x, double y, char procedure) {
        return operations.get(procedure).applyAsDouble(x, y);
    }

    static {
        operations = new HashMap<>();
        operations.put('-', (x, y) -> x - y);
        operations.put('+', Double::sum);
        operations.put('/', (x, y) -> x / y);
        operations.put('*', (x, y) -> x * y);
        operations.put('^', Math::pow);
    }
}
