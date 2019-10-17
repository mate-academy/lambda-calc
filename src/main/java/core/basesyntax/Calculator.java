package core.basesyntax;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Calculator {
    private static HashMap<Character, ExecuteFunc> map;

    static {
        map = new HashMap<>();
        map.put('+', Calculator::sum);
        map.put('-', Calculator::difference);
        map.put('*', Calculator::multiply);
        map.put('/', Calculator::divide);
        map.put('^', Calculator::pow);
    }

    public static double calculate(double firstValue, char operator, double secondValue) {
        ExecuteFunc func = map.get(operator);
        if (func == null) {
            throw new NoSuchElementException("Incorrect operator in calculate function.");
        }
        return func.execute(firstValue, secondValue);
    }

    private static double sum(double a, double b) {
        return a + b;
    }

    private static double difference(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return a / b;
    }

    private static double pow(double a, double b) {
        return Math.pow(a, b);
    }
}
