package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static Map<Character, DoubleBinaryOperator> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put('+', Double::sum);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a , b) -> a / b);
        operations.put('^', Math::pow);
    }

    public Double calculate(double a, double b, char operation) {
        DoubleBinaryOperator operator = operations.get(operation);
        if (operator == null) {
            throw new ArithmeticException(
                    "Wrong operator provided, can't execute current operation");
        }
        return (Double) operator.applyAsDouble(a, b);
    }
}
