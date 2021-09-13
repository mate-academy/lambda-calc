package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) throws IllegalArgumentException {
        if (!isLegalOperation(operation)) {
            throw new IllegalArgumentException("Operation " + operation
                    + " is not allowed. Please input operation from +, - , *, /, ^ ");
        }
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == Double.NEGATIVE_INFINITY || b == Double.POSITIVE_INFINITY || b == 0) {
                    throw new IllegalArgumentException("IllegalArgumentException is occured");
                }
                return a / b;
            case '^':
                if (a == 0 && b <= 0) {
                    throw new IllegalArgumentException("IllegalArgumentException is occured."
                            + " Number b must be > 0. ");
                }
                return Math.pow(a, b);
            default:
                return 0;
        }
    }

    private boolean isLegalOperation(char operation) {
        String allowedOperations = "+-*/^";
        if (!allowedOperations.contains(String.valueOf(operation))) {
            return false;
        }
        return true;
    }
}
