package core.basesyntax;

import java.math.BigDecimal;

public class Calculate {

    public static BigDecimal calculate(BigDecimal firstNumber,
                                       BigDecimal secondNumber, char operation) {
        Operationable<BigDecimal> op;
        switch (operation) {
            case '+':
                op = (x, y) -> x.add(y);
                return op.compute(firstNumber, secondNumber);
            case '-':
                op = (x, y) -> x.subtract(y);
                return op.compute(firstNumber, secondNumber);
            case '/':
                if (secondNumber.equals(BigDecimal.valueOf(0))) {
                    throw new IllegalArgumentException("Can't divide by zero");
                }
                op = (x, y) -> x.divide(y);
                return op.compute(firstNumber, secondNumber);
            case '*':
                op = (x, y) -> x.multiply(y);
                return op.compute(firstNumber, secondNumber);
            case '^':
                op = (x, y) -> x.pow(Integer.parseInt(String.valueOf(y)));
                return op.compute(firstNumber, secondNumber);
            default: throw new IllegalArgumentException("Operation is not valid");
        }
    }
}
