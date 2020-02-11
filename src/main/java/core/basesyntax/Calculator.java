package core.basesyntax;

import core.basesyntax.exceptions.UndefinedOperationException;

import java.util.function.DoubleBinaryOperator;

public class Calculator {

    public double calculate(double a, double b, char operation) {
        DoubleBinaryOperator result = (operation == '+') ? (x, y) -> x + y
                : (operation == '-') ? (x, y) -> x - y
                : (operation == '*') ? (x, y) -> x * y
                : (operation == '/') ? (x, y) -> x / y
                : (operation == 'p') ? (x, y) -> Math.pow(x, y)
                : (x, y) -> {
                    throw new UndefinedOperationException("Use + for addition, - for substraction,"
                    + " * for multiplication, / for divisiion and p for powering");
                };
        return result.applyAsDouble(a, b);
    }
}
