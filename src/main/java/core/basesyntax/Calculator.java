package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private Map<Character, BiFunction<Double, Double, Double>> methodMap = new HashMap<>();

    public Calculator() {
        methodMap.put('+', Double::sum);
        methodMap.put('-', (arg1, arg2) -> arg1 - arg2);
        methodMap.put('*', ((arg1, arg2) -> arg1 * arg2));
        methodMap.put('/', ((arg1, arg2) -> arg1 / arg2));
        methodMap.put('^', Math::pow);
    }

    public double calculate(double arg1, double arg2, char operation) {
        try {
            return methodMap.get(operation).apply(arg1, arg2);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Illegal argument '" + operation + "'");
        }
    }
}
