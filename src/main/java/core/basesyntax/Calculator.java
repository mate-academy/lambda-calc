package core.basesyntax;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calculator {
    private static HashMap<Character, BinaryOperator<Long>> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(Character.valueOf('+'), Long::sum);
        hashMap.put(Character.valueOf('-'), (a, b) -> a - b);
        hashMap.put(Character.valueOf('/'), (a, b) -> a / b);
        hashMap.put(Character.valueOf('*'), (a, b) -> a * b);
        hashMap.put(Character.valueOf('^'), (a, b) -> (long) Math.pow(a, b));
    }

    public static Long apply(Long a, Character operation, Long b)
            throws IllegalArgumentException, NullPointerException {
        return hashMap.get(operation).apply(a, b);
    }
}
