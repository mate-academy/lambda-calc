package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private static final HashMap<Character, DoubleBinaryOperator> OPERATIONS;

    static {
        OPERATIONS = new HashMap<>();
        OPERATIONS.put('+', (Double::sum));
        OPERATIONS.put('-', (a, b) -> a - b);
        OPERATIONS.put('*', (a, b) -> a * b);
        OPERATIONS.put('/', (a, b) -> a / b);
        OPERATIONS.put('^', Math::pow);
    }

    public double calculate(double a, double b, char operator) {
        if (operator == '/' && b == 0) {
            throw new ArithmeticException("Can't division by zero!");
        }
        return OPERATIONS.get(operator).applyAsDouble(a, b);
    }
}
