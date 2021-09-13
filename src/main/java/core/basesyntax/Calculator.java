package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operator) {
        checkForNull(a);
        checkForNull(b);
        checkOperator(operator);
        double result;
        switch (operator) {
            case ('+'):
                result = a + b;
                break;
            case ('-'):
                result = a - b;
                break;
            case ('/'):
                if (b == 0) {
                    throw new DivisionByZeroException("DivisionByZero");
                }
                result = a / b;
                break;
            case ('*'):
                result = a * b;
                break;
            case ('^'):
                result = Math.pow(a, b);
                if (a != 0 && result == 0) {
                    throw new MinMaxValueException("Failed check for min max value");
                }
                break;
            default:
                throw new MinMaxValueException("Failed check for min max value");
        }

        return checkForMinMaxValue(result);
    }

    private void checkForNull(Object a) {
        if (a == null) {
            throw new RuntimeException();
        }
    }

    private void checkOperator(char operator) {
        switch (operator) {
            case ('+') :
            case ('^') :
            case ('-') :
            case ('*') :
            case ('/') :
                return;
            default:
                throw new RuntimeException();
        }
    }

    private double checkForMinMaxValue(double a) {
        if (Math.abs(a) >= Math.pow(2, 1023)) {
            throw new MinMaxValueException("Failed check for min max value");
        }
        return a;
    }
}
