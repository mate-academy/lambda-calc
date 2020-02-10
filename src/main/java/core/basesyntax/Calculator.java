package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Calculator {

    public double calculate(double num1, double num2, char operator) {
        Map<Character, DoubleBinaryOperator> map = new HashMap();
        map.put('+', Double::sum);
        map.put('-', (a, b) -> a - b);
        map.put('/', (a, b) -> a / b);
        map.put('*', (a, b) -> a * b);
        map.put('^', Math::pow);
        return map.get(operator).applyAsDouble(num1, num2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(2, 2, '^'));
    }
}
