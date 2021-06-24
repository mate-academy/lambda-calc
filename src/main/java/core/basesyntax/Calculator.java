package core.basesyntax;

import java.math.BigDecimal;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public BigDecimal calculate(double first, double second, char operation) {
        switch (operation) {
            case PLUS:
                return BigDecimal.valueOf(first + second);
            case MINUS:
                return BigDecimal.valueOf(first - second);
            case MULTIPLICATION:
                return BigDecimal.valueOf(first * second);
            case DIVISION:
                if (second == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                return BigDecimal.valueOf(first / second);
            case POWER:
                if (first == 0 && second < 0) {
                    throw new ArithmeticException("Zero cannot have negative power!");
                }
                if (first < 0 && second != 0) {
                    throw new ArithmeticException("Result is NaN!");
                }
                return BigDecimal.valueOf(Math.pow(first, second));
            default:
                throw new IllegalArgumentException("No such operation: " + operation);
        }
    }
}
