package core.basesyntax;

public class MyCalculator implements Calculator {
    private static final double POSITIVE_MAX_VALUE = Double.MAX_VALUE;
    private static final double NEGATIVE_MAX_VALUE = -Double.MAX_VALUE;
    private static final String TOO_LARGE_VALUE = "Too large or little result!";
    private static final char SIGN_ADDITION = '+';
    private static final char SIGN_SUBTRACTION = '-';
    private static final char SIGN_DIVISION = '/';
    private static final char SIGN_MULTIPLICATION = '*';
    private static final char SIGN_RAISING_TO_A_POWER = '^';

    public double calculate(double a, double b, char sing) throws MyCalculateException {
        switch (sing) {
            case SIGN_MULTIPLICATION: {
                checkException(a * b);
                return a * b;
            }
            case SIGN_DIVISION: {
                if (b == 0) {
                    throw new MyCalculateException("Can't be divided by zero!");
                }
                checkException(a / b);
                return a / b;
            }
            case SIGN_ADDITION: {
                checkException(a + b);
                return a + b;
            }
            case SIGN_SUBTRACTION: {
                checkException(a - b);
                return a - b;
            }
            case SIGN_RAISING_TO_A_POWER: {
                checkException(Math.pow(a, b));
                return Math.pow(a, b);
            }
            default: {
                throw new MyCalculateException("A sing isn't correct!");
            }
        }
    }

    private void checkException(double result) throws MyCalculateException {
        if (result >= POSITIVE_MAX_VALUE || result <= NEGATIVE_MAX_VALUE) {
            throw new MyCalculateException(TOO_LARGE_VALUE);
        }
    }
}
