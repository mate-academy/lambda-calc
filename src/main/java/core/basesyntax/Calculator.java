package core.basesyntax;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calculator {

    private static HashMap<Character, BinaryOperator<Double>> calculator = new HashMap();

    static {
        calculator.put('+', Double::sum);
        calculator.put('-', (x, y) -> x - y);
        calculator.put('*', (x, y) -> x * y);
        calculator.put('/', (x, y) -> x / y);
        calculator.put('^', Math::pow);
    }

    public double calculate(Character operation, double first, double second) {
        try {
            return calculator.get(operation).apply(first,second);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Incorrect input operation symbol");
        }
    }
}
