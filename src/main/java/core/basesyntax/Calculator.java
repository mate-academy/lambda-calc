package core.basesyntax;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.IllegalOperatorException;
import core.basesyntax.exception.InvalidValuesException;

public class Calculator {
    public double calculate(double a, double b, char operator) {
        isValidOperator(operator);
        return operator == '+' ? add(a, b) :
               operator == '-' ? subtract(a, b) :
               operator == '/' ? divide(a, b) :
               operator == '*' ? multiply(a, b) :
               raiseToPower(a, b);
    }

    private boolean isValidOperator(char operator) {
        String operators = "+-*/^";
        if (!operators.contains(String.valueOf(operator))) {
            throw new IllegalOperatorException("Illegal operator");
        }
        return true;
    }

    private double add(double a, double b) {
        if (a == Integer.MAX_VALUE && b > 0 || b == Integer.MAX_VALUE && a > 0
                || a == Integer.MIN_VALUE && b < 0 || b == Integer.MIN_VALUE && a < 0) {
            throw new InvalidValuesException("Out of range Integer. Operation - addition");
        }
        return a + b;
    }

    private double subtract(double a, double b) {
        if (a == Integer.MAX_VALUE && b < 0 || b == Integer.MAX_VALUE && a < 0
                || a == Integer.MIN_VALUE && b > 0 || b == Integer.MIN_VALUE && a > 0) {
            throw new InvalidValuesException("Out of range Integer. Operation - subtraction");
        }
        return a - b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        return a / b;
    }

    private double multiply(double a, double b) {
        return Math.abs(a * b) == 0 ? 0 : a * b;
    }

    private double raiseToPower(double a, double power) {
        return Math.pow(a, power);
    }
}
