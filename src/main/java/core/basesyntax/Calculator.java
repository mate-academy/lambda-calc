package core.basesyntax;

public class Calculator implements Calculatable {
    @Override
    public double calculate(double a, double b, char sign) {
        switch (sign) {
            case '+': {
                return a + b;
            }
            case '-': {
                return a - b;
            }
            case '/': {
                if (b == 0) {
                    throw new ArithmeticException("Division by 0 has not result");
                }
                return a / b;
            }
            case '^': {
                if (a < 0 && b < 0 && b % 2 != 0) {
                    throw new ArithmeticException("The result of raising negative number "
                                                + "to a fractional power is not a number");
                }
                return Math.pow(a, b);
            }
            case '*': {
                return a * b;
            }
            default: {
                throw new IllegalArgumentException("An illegal character was passed");
            }
        }
    }
}
