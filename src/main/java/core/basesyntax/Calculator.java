package core.basesyntax;

import core.basesyntax.exeption.DataProcessingException;
import java.util.function.BinaryOperator;

public class Calculator {

    private static Double apply(Double num1, Double num2) {
        throw new DataProcessingException("Sorry, we don't have another operation!");
    }

    public static Double calculate(Double x1, Double x2, char operation) {
        BinaryOperator<Double> operator =
                operation == '+' ? (num1, num2) -> (num1 + num2) :
                        operation == '-' ? (num1, num2) -> (num1 - num2) :
                                operation == '*' ? (num1, num2) -> (num1 * num2) :
                                        operation == '^' ? (num1, num2) -> (Math.pow(num1, num2)) :
                                                operation == '/' ? (num1, num2) -> (num1 / num2) :
                                                        Calculator::apply;
        return operator.apply(x1, x2);
    }
}
