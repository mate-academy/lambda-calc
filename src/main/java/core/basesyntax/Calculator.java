package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    static HashMap<Character, DoubleBinaryOperator> operations = new HashMap<>();

    public double calculate(double firstNum, double secondNum, char symbol) {
        operations.put('+', Double::sum);
        operations.put('-', (x, y) -> x - y);
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
        operations.put('^', Math::pow);
        return operations.get(symbol).applyAsDouble(firstNum, secondNum);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(0, -1, '^'));

    }
}
