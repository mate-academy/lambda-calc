package core.basesyntax;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.LongBinaryOperator;

public class Calculator {
    private final HashMap<Character, LongBinaryOperator> operations = new HashMap<>();

    public Calculator() {
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
        operations.put('+', Long::sum);
        operations.put('-', (x, y) -> x - y);
        operations.put('^', (x, y) -> (long) Math.pow(x, y));
    }

    public long calculate(long x, long y, char operation) {
        return Optional.ofNullable(operations.get(operation))
                .map(o -> o.applyAsLong(x, y))
                .orElseThrow(IllegalArgumentException::new);
    }
}
