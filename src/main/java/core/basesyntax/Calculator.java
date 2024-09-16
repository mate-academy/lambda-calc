package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '-':
                return a - b;
            case '+':
                return a + b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot be divisible by 0");
                }
                return a / b;
            case '*':
                return a * b;
            case '^':
                if (a < 0 && b < 0 && b % 2 != 0) {
                    throw new ArithmeticException("You can't raise a "
                            + "negative number to a fractional power");
                }
                return Math.pow(a, b);
            default:
                throw new RuntimeException("No such operation: " + operation);
        }
    }
}
