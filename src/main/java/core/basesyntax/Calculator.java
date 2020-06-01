package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final HashMap<Character, DoubleBinaryOperator> OPERATION_MAP;

    static {
        OPERATION_MAP = new HashMap<>();
        OPERATION_MAP.put('+', (a, b) -> a + b);
        OPERATION_MAP.put('-', (a, b) -> a - b);
        OPERATION_MAP.put('*', (a, b) -> a * b);
        OPERATION_MAP.put('/', (a, b) -> a / b);
        OPERATION_MAP.put('^', Math::pow);
    }

    public double calculate(double a, char operator, double b) {
        return OPERATION_MAP.get(operator).applyAsDouble(a, b);
    }
}
