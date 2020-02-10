package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(Character operation, double firstValue, double secondValue) {
        if (!operation.toString().matches("[-+*/^]")
                || secondValue == 0) {
            throw new ArithmeticException("Wrong operation");
        }
        DoubleBinaryOperator binaryOperator = operation == '+' ? Double::sum
                : operation == '-' ? ((left, right) -> left - right)
                : operation == '*' ? (left, right) -> left * right
                : operation == '/' ? (left, right) -> left / right
                : Math::pow;
        return binaryOperator.applyAsDouble(firstValue, secondValue);
    }
}
