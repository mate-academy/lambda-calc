package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private final HashMap<Character, DoubleBinaryOperator> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put('+', Double::sum);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> a / b);
        operations.put('-', (a, b) -> a - b);
        operations.put('^', Math::pow);
    }

    public Double calculate(Double a, Double b, Character operation) {
            DoubleBinaryOperator doubleBinaryOperator = operations.get(operation);
            return doubleBinaryOperator.applyAsDouble(a, b);
    }
}
