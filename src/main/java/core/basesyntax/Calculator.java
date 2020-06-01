package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    static HashMap<Character, DoubleBinaryOperator> operations = new HashMap<>();

    static {
        operations.put('+', Double::sum);
        operations.put('-', (x, y) -> x - y);
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
        operations.put('^', Math::pow);
    }

    public double calculate(double firstNum, double secondNum, char symbol) {
        return operations.get(symbol).applyAsDouble(firstNum, secondNum);
    }
}
