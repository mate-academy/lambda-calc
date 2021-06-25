package core.basesyntax;

public class LamdaCalculator {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING = '^';

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ADDITION:
                return a + b;
            case SUBSTRACTION:
                return a - b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Can`t make division by 0, go back to school!");
                }
                return a / b;
            case MULTIPLICATION:
                return a * b;
            case RAISING:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Вad idea to this operation - "
                        + operation + " try new!.");
        }
    }
}
