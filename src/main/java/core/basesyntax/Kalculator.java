package core.basesyntax;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Kalculator {
    private static final HashMap<Character, BiFunction<Integer, Integer, Integer>> map = new HashMap<>() {
        final BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        final BiFunction<Integer, Integer, Integer> div = Math::floorDiv;
        final BiFunction<Integer, Integer, Integer> multi = Math::multiplyExact;
        final BiFunction<Integer, Integer, Integer> minus = Math::subtractExact;

        {
            put('+', sum);
            put('/', div);
            put('*', multi);
            put('-', minus);
        }
    };

    public static void main(String[] args) {
        Long long1 = 100L;

        System.out.println(evaluate(10, 5, '+'));
        System.out.println(evaluate(14, 5, '/'));
        System.out.println(evaluate(14, 5, '-'));
        System.out.println(evaluate(14, 5, '*'));
    }

    public static int evaluate(int a, int b, char c) {
        return map.get(c).apply(a, b);
    }
}
