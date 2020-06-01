package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final HashMap<Character, DoubleBinaryOperator> OPERATORS;

    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put('+', (Double::sum));
        OPERATORS.put('-', (a, b) -> a - b);
        OPERATORS.put('*', (a, b) -> a * b);
        OPERATORS.put('/', (a, b) -> a / b);
        OPERATORS.put('^', Math::pow);
    }

    public double calculate(double a, char operator, double b) {
        return OPERATORS.get(operator).applyAsDouble(a, b);
    }

    public static void main(String[] args) {

    }
}
