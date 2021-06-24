package core.basesyntax;

import java.math.BigDecimal;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';

    public BigDecimal calculate(double number1, double number2, char operation) {
        switch (operation) {
            case PLUS:
                return BigDecimal.valueOf(number1 + number2);
            case MINUS:
                return BigDecimal.valueOf(number1 - number2);
            case MULTIPLY:
                return  BigDecimal.valueOf(number1 * number2);
            case DIVIDE:
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                return BigDecimal.valueOf(number1 / number2);
            case POWER:
                if (number1 == 0 && number2 < 0) {
                    throw new ArithmeticException("Zero cannot have negative power!");
                }
                if (number1 < 0 && number2 != 0) {
                    throw new NumberFormatException("Result is NaN!");
                }
                return BigDecimal.valueOf(Math.pow(number1, number2));
            default:
                throw new IllegalArgumentException("No such operation: " + operation);
        }
    }
}
