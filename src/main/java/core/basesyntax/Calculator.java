package core.basesyntax;

import core.basesyntax.exceptions.UndefinedOperationException;

import java.util.function.DoubleBinaryOperator;

public class Calculator {

    public double calculate(double a, double b, char f) {
        DoubleBinaryOperator result = (f == '+') ? (x, y) -> x + y
                : (f == '-') ? (x, y) -> x - y
                : (f == '*') ? (x, y) -> x * y
                : (f == '/') ? (x, y) -> x / y
                : (f == 'p') ? (x, y) -> Math.pow(x, y)
                : (x, y) -> {
                    throw new UndefinedOperationException("Use + for addition, - for substraction,"
                    + " * for multiplication, / for divisiion and p for powering");
                };
        return result.applyAsDouble(a, b);
    }
}
