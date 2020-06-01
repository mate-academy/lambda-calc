package core.basesyntax;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Calculator {
    private final HashMap<Character, BiFunction<Double, Double, Double>> map =
            new HashMap<>() {
            private final BiFunction<Double, Double, Double> sum = Double::sum;
            private final BiFunction<Double, Double, Double> div = (a, b) -> a / b;
            private final BiFunction<Double, Double, Double> multi = (a, b) -> a * b;
            private final BiFunction<Double, Double, Double> minus = (a, b) -> a - b;
            private final BiFunction<Double, Double, Double> power = Math::pow;

            {
                put('^', power);
                put('+', sum);
                put('/', div);
                put('*', multi);
                put('-', minus);
            }
    };

    public double evaluate(double firstNumber, double secondNumber, char operator) {
        return map.get(operator).apply(firstNumber, secondNumber);
    }
}
