package core.basesyntax;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class Calculator {
    public BigDecimal calculate(BigDecimal a, BigDecimal b, char operation) {
        BinaryOperator<BigDecimal> operator
                = operation == '+' ? BigDecimal::add
                : operation == '-' ? BigDecimal::subtract
                : operation == '*' ? BigDecimal::multiply
                : operation == '/' ? BigDecimal::divide
                : operation == '^' ? (num1, num2) -> num1.pow(num2.intValue())
                : null;
        if (operator == null) {
            throw new IllegalArgumentException("Operation is not supported!");
        }
        return operator.apply(a, b);
    }
}
