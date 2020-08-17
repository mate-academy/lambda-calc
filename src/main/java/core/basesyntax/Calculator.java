package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLE = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final double DELTA = 0.000_001;

    public double calculate(double a, double b, char sign) {
        switch (sign) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLE:
                return a * b;
            case DIVISION:
                if (Math.abs(b) < DELTA) {
                    throw new IllegalArgumentException("Can't div by zero");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Wrong sign");
        }
    }
}
