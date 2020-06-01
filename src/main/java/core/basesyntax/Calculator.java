package core.basesyntax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

public class Calculator {
    public BigDecimal calculate(BigDecimal a, BigDecimal b, char operation) {
        BinaryOperator<BigDecimal> operator
                = operation == '+' ? BigDecimal::add
                : operation == '-' ? BigDecimal::subtract
                : operation == '*' ? BigDecimal::multiply
                : operation == '/' ? (num1, num2) -> num1.divide(num2, 2, RoundingMode.HALF_UP)
                : operation == '^' ? (num1, num2) -> num1.pow(num2.intValue())
                : (num1, num2) -> {
                    throw new IllegalArgumentException("Operation is not supported!");
                };
        return operator.apply(a, b);
    }
}
