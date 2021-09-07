package core.basesyntax;

public class MyCalculator implements Calculator {
    private static final String TOO_LARGE_VALUE = "Too large or little result!";
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    public double calculate(double a, double b, char sing) throws MyCalculateException {
        switch (sing) {
            case MULTIPLICATION: {
                checkMaxMinValues(a * b);
                return a * b;
            }
            case DIVISION: {
                if (b == 0) {
                    throw new MyCalculateException("Can't be divided by zero!");
                }
                checkMaxMinValues(a / b);
                return a / b;
            }
            case ADDITION: {
                checkMaxMinValues(a + b);
                return a + b;
            }
            case SUBTRACTION: {
                checkMaxMinValues(a - b);
                return a - b;
            }
            case RAISING_TO_A_POWER: {
                checkMaxMinValues(Math.pow(a, b));
                return Math.pow(a, b);
            }
            default: {
                throw new UnsupportedOperationException("A sing isn't correct!");
            }
        }
    }

    private void checkMaxMinValues(double result) throws MyCalculateException {
        if (!Double.isFinite(result)) {
            throw new MyCalculateException(TOO_LARGE_VALUE);
        }
    }
}
