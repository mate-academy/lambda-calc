package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double num1, double num2, Character operator) {
        if (num2 == 0 && operator == '/') {
            throw new IllegalArgumentException("Division by 0 is not possible");
        }
        Map<Character, DoubleBinaryOperator> mathOperations = new HashMap<>();
        mathOperations.put('+', Double::sum);
        mathOperations.put('-', (a, b) -> a - b);
        mathOperations.put('*', (a, b) -> a * b);
        mathOperations.put('/', (a, b) -> a / b);
        mathOperations.put('^', Math::pow);
        return mathOperations.get(operator).applyAsDouble(num1, num2);
    }
}
