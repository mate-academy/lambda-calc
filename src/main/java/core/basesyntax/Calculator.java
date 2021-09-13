package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) throws IllegalArgumentException {
        checkLegalOperation(operation);
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return divide(a, b);
            case '^':
                return raiseValueToPower(a, b);
            default:
                return 0;
        }
    }

    private double divide(double a, double b) {
        if (b == Double.NEGATIVE_INFINITY || b == Double.POSITIVE_INFINITY || b == 0) {
            throw new IllegalArgumentException("IllegalArgumentException is occured");
        }
        return a / b;
    }

    private double raiseValueToPower(double a, double b) {
        if (a == 0 && b <= 0) {
            throw new IllegalArgumentException("IllegalArgumentException is occured."
                    + " Number b must be > 0. ");
        }
        return Math.pow(a, b);
    }

    private void checkLegalOperation(char operation) throws IllegalArgumentException {
        String allowedOperations = "+-*/^";
        if (!allowedOperations.contains(String.valueOf(operation))) {
            throw new IllegalArgumentException("Operation " + operation
                    + " is not allowed. Please input operation from +, - , *, /, ^ ");
        }
    }
}
