package core.basesyntax;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Kalculator {
    private static final HashMap<Character, BiFunction<Double, Double, Double>> map =
            new HashMap<>() {
            final BiFunction<Double, Double, Double> sum = Double::sum;
            final BiFunction<Double, Double, Double> div = (a, b) -> a / b;
            final BiFunction<Double, Double, Double> multi = (a, b) -> a * b;
            final BiFunction<Double, Double, Double> minus = (a, b) -> a - b;
            final BiFunction<Double, Double, Double> power = Math::pow;

            {
                put('^', power);
                put('+', sum);
                put('/', div);
                put('*', multi);
                put('-', minus);
            }
    };

    public static double evaluate(double a, double b, char c) {
        return map.get(c).apply(a, b);
    }
}
