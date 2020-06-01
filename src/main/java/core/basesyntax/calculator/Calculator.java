package core.basesyntax.calculator;

import java.util.function.BiFunction;

public class Calculator {
    public double calculate(double firstParameter, double secondParameter, char operation) {
        if (operation == '/' && secondParameter == 0) {
            throw new ArithmeticException("Second parameter can't be zero");
        }
        final BiFunction<Double, Double, Double> function = operation == '+'
                ? (a, b) -> a + b : operation == '-'
                ? (a, b) -> a - b : operation == '*'
                ? (a, b) -> a * b : operation == '/'
                ? (a, b) -> a / b : operation == '^'
                ? (a, b) -> Math.pow(a, b) : null;
        if (function == null) {
            throw new IllegalArgumentException("Wrong operator character");
        }
        return function.apply(firstParameter, secondParameter);
    }
}
