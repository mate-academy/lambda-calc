package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {

    public Double calculate(Double a, Double b, Character c) {
        Map<Character, DoubleBinaryOperator> operations = new HashMap<>();
        operations.put('+', Double::sum);
        operations.put('-', (o1, o2) -> o1 - o2);
        operations.put('*', (o1, o2) -> o1 * o2);
        operations.put('/', (o1, o2) -> o1 / o2);
        operations.put('^', Math::pow);
        return operations.get(c).applyAsDouble(a, b);
    }
}
