package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculator(int first, int second, char operator) {
        Map<Character, Operationable> map = createCalculator();
        Operationable operation = map.get(operator);
        if (!map.containsKey(operator)) {
            throw new IllegalArgumentException("Unknown operator");
        }
        return operation.calculate(first, second);
    }

    public Map<Character, Operationable> createCalculator() {
        Map<Character, Operationable> map = new HashMap<>();
        Operationable operation = ((x, y) -> x + y);
        map.put(PLUS, operation);
        operation = ((x, y) -> x - y);
        map.put(MINUS, operation);
        operation = ((x, y) -> x * y);
        map.put(MULTIPLICATION, operation);
        operation = ((x, y) -> x / y);
        map.put(DIVISION, operation);
        operation = ((x, y) -> (int) Math.pow(x, y));
        map.put(POWER, operation);
        return map;
    }

    interface Operationable {
        int calculate(int x, int y);
    }

}
