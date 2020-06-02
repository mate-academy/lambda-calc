package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private HashMap<Character, DoubleBinaryOperator> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put('+', Double::sum);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> a / b);
        operations.put('^', Math::pow);
    }

    public double calculate(Double a, Double b, Character character) {
        DoubleBinaryOperator operator = operations.get(character);
        if (operator == null) {
            throw new IllegalArgumentException();
        }
        return operator.applyAsDouble(a,b);
    }
}
