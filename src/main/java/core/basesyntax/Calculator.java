package core.basesyntax;

public class Calculator implements Calculatable {

    @Override
    public double calculate(double a, double b, char sign) {
        switch (sign) {
            case 43: {
                return a + b;
            }
            case 45: {
                return a - b;
            }
            case 47: {
                if (b == 0) {
                    throw new ArithmeticException("Division by 0 has not result");
                }
                return a / b;
            }
            case 94: {
                return Math.pow(a, b);
            }
            case 42: {
                return a * b;
            }
            default: {
                throw new IllegalArgumentException("An illegal character was passed");
            }
        }
    }
}
