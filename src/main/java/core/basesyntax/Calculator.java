package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operation) {
        //double result = 0;
        switch (operation) {
            case '+':
                checkForDoubleMinValue(a, b);
                checkForDoubleMaxValue(a, b);
                return a + b;
            case '-':
                checkForDoubleMinValue(a, b);
                checkForDoubleMaxValue(a, b);
                return a - b;
            case '*':
                checkForDoubleMinValue(a, b);
                checkForDoubleMaxValue(a, b);
                return a * b;
            case '/':
                checkForDoubleMinValue(a, b);
                checkForDoubleMaxValue(a, b);
                if (b == 0) {
                    throw new ArithmeticException();
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void checkForDoubleMinValue(double a, double b) {
        if (a == Double.MIN_VALUE || b == Double.MIN_VALUE) {
            throw new RuntimeException();
        }
    }

    private void checkForDoubleMaxValue(double a, double b) {
        if (a == Double.MAX_VALUE || b == Double.MAX_VALUE) {
            throw new RuntimeException();
        }
    }
}
