package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private final HashMap<Character, DoubleBinaryOperator> operations = new HashMap<>() {{
            put('+', (a, b) -> a + b);
            put('-', (a, b) -> a - b);
            put('*', (a, b) -> a * b);
            put('/', (a, b) -> a / b);
            put('^', Math::pow);
        }};

    public double calculate(double a, char operator, double b) {
        DoubleBinaryOperator op = operations.get(operator);
        if (op == null) {
            throw new IllegalArgumentException("Operation '" + op + "' is not supported.");
        }
        return op.applyAsDouble(a, b);
    }

    public static void main(String[] args) {
        System.out.println("Hello from the other side...");
    }
}
