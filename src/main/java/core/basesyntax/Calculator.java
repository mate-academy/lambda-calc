package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private Map<Character, BiFunction<Double, Double, Double>> operators = new HashMap<>();

    public Calculator() {
        operators.put('+', Double::sum);
        operators.put('-', (value1, value2) -> value1 - value2);
        operators.put('*', ((value1, value2) -> value1 * value2));
        operators.put('/', ((value1, value2) -> value1 / value2));
        operators.put('^', Math::pow);
    }

    public double calculate(double value1, double value2, char operation) {
        return operators.get(operation).apply(value1, value2);
    }
}
