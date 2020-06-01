package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {

    public static double calculate(double firstArgument,
                                   double secondArgument, Character operation) {
        if (!operation.toString().matches("[-+*/^]")) {
            throw new ArithmeticException("Wrong operation");
        } else if (operation == '/' && secondArgument == 0) {
            throw new ArithmeticException("Division by zero");
        }
        DoubleBinaryOperator binaryOperator =
                operation == '+' ? Double::sum
                        : operation == '-' ? (first, second) -> first - second
                        : operation == '*' ? (first, second) -> first * second
                        : operation == '/' ? (first, second) -> first / second
                        : Math::pow;
        return binaryOperator.applyAsDouble(firstArgument, secondArgument);
    }
}
