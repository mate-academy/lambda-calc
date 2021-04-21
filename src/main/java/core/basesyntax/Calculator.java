package core.basesyntax;

public class Calculator implements Calculatable {

    @Override
    public double calculate(double a, double b, char sign) {
        if (sign != 42 && sign != 43 && sign != 45 && sign != 47 && sign != 94) {
            throw new IllegalArgumentException("An illegal character was passed");
        }
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
            default: {
                break;
            }
        }
        return a * b;
    }
}
