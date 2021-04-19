package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operationType) {
        switch (operationType) {
            case ('+'):
                checkNumbers(number1, number2, operationType);
                return number1 + number2;
            case ('-'):
                checkNumbers(number1, number2, operationType);
                return number1 - number2;
            case ('*'):
                checkNumbers(number1, number2, operationType);
                return number1 * number2;
            case ('/'):
                checkNumbers(number1, number2, operationType);
                return number1 / number2;
            case ('^'):
                checkNumbers(number1, number2, operationType);
                if (number1 < 0) {
                    return Math.pow(number1 * -1, number2) * -1;
                }
                return Math.pow(number1, number2);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void checkNumbers(double number1, double number2, char operationType) {
        switch (operationType) {
            case ('+'):
                if (number1 + number2 >= Double.MAX_VALUE
                        || number1 + number2 <= -Double.MAX_VALUE) {
                    throw new LimitDoubleValueReachedException("Double limit reached, "
                            + "calculations may not be correct");
                }
                break;
            case ('-'):
                if (number1 - number2 >= Double.MAX_VALUE
                        || number1 - number2 <= -Double.MAX_VALUE) {
                    throw new LimitDoubleValueReachedException("Double limit reached, "
                            + "calculations may not be correct");
                }
                break;
            case ('*'):
                if (number1 * number2 >= Double.POSITIVE_INFINITY
                        || number1 * number2 <= Double.NEGATIVE_INFINITY) {
                    throw new LimitDoubleValueReachedException("Double limit reached, "
                            + "calculations may not be correct");
                }
                break;
            case ('/'):
                if (number2 == 0) {
                    throw new ArithmeticException();
                }
                if (number1 / number2 >= Double.POSITIVE_INFINITY
                        || number1 / number2 <= Double.NEGATIVE_INFINITY) {
                    throw new LimitDoubleValueReachedException("Double limit reached, "
                            + "calculations may not be correct");
                }
                break;
            case ('^'):
                if (Math.pow(number1, number2) >= Double.MAX_VALUE
                        || (Math.pow(number1, number2) <= -Double.MAX_VALUE)) {
                    throw new LimitDoubleValueReachedException("Double limit reached, "
                            + "calculations may not be correct");
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
