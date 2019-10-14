package core.basesyntax;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calculator {
    private static Logger LOGGER = Logger.getLogger(Calculator.class);
    private static HashMap<Character, BinaryOperator<Long>> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(Character.valueOf('+'), Long::sum);
        hashMap.put(Character.valueOf('-'), (a, b) -> a - b);
        hashMap.put(Character.valueOf('/'), (a, b) -> a / b);
        hashMap.put(Character.valueOf('*'), (a, b) -> a * b);
        hashMap.put(Character.valueOf('^'), (a, b) -> (long)Math.pow(a, b));
    }

    public static Long apply(Long a, Character op, Long b)
            throws IllegalArgumentException, NullPointerException{
        return hashMap.get(op).apply(a, b);
    }
}
