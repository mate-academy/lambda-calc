package core.basesyntax;

import java.util.HashMap;
import java.util.function.LongBinaryOperator;

public class Calculator {
    private final HashMap<Character, LongBinaryOperator> operations = new HashMap<>();

    public Calculator() {
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
        operations.put('+', Long::sum);
        operations.put('-', (x, y) -> x - y);
        operations.put('^', (x, y) -> (long) Math.pow(x,y));
    }

    public long calculate(long x, long y, char operation) {
        return operations.keySet().stream()
                .filter(c -> c.equals(operation))
                .map(c -> operations.get(c).applyAsLong(x, y))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
