package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculation {
    private static final Map<Character, DoubleBinaryOperator> COMPUTATION = new HashMap<>();

    static {
        COMPUTATION.put('+', (x, y) -> x + y);
        COMPUTATION.put('-', (x, y) -> x - y);
        COMPUTATION.put('*', (x, y) -> x * y);
        COMPUTATION.put('/', (x, y) -> x / y);
        COMPUTATION.put('^', (x, y) -> Math.pow(x, y));
    }

    public double calculate(double x, double y, char operation) {
        if (y == 0.0 && operation == '/') {
            throw new ArithmeticException("Division by zero results in infinity");
        }
        if (!COMPUTATION.containsKey(operation)) {
            throw new IllegalArgumentException("Provided operation is not supported");
        }
        if (COMPUTATION.get(operation).applyAsDouble(x, y) >= Double.MAX_VALUE) {
            throw new ArithmeticException("Provided inputs produce the result that exceeds "
                    + "calculus possibilities");
        }
        return COMPUTATION.get(operation).applyAsDouble(x, y);
    }
}
