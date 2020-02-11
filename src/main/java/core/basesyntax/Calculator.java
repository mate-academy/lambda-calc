package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private Map<Character, BiFunction<Double, Double, Double>> calculator;

    public Calculator() {
        calculator = new HashMap<>();
        calculator.put('+', Double::sum);
        calculator.put('-', (x, y) -> x - y);
        calculator.put('*', (x, y) -> x * y);
        calculator.put('/', (x, y) -> x / y);
        calculator.put('^', Math::pow);
    }

    public double calculate(Character operation, double a, double b) {
        return calculator.get(operation).apply(a, b);
    }
}
