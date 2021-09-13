package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) throws IllegalArgumentException {
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
                throw new IllegalArgumentException("Operation " + operation
                        + " is not allowed. Please input operation from +, - , *, /, ^ ");
        }
    }

    private double divide(double a, double b) {
        if (b == Double.NEGATIVE_INFINITY || b == Double.POSITIVE_INFINITY || b == 0) {
            throw new IllegalArgumentException("IllegalArgumentException is occured. "
                    + " Divider must not be 0.");
        }
        return a / b;
    }

    private double raiseValueToPower(double a, double b) {
        if (a == 0 && b <= 0) {
            throw new IllegalArgumentException("IllegalArgumentException is occured."
                    + " Power must be > 0. ");
        }
        return Math.pow(a, b);
    }
}
