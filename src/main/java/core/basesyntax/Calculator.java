package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Can't divide on zero!");
                }
                return a / b;
            case '*':
                return a * b;
            case '^':
                if (a == 0) {
                    throw new ArithmeticException("Can't power zero!");
                }
                return Math.pow(a, b);
            case '%':
                if (b == 0) {
                    throw new ArithmeticException("Can't divide on zero!");
                }
                return a % b;
            default:
                throw new IllegalArgumentException("Wrong operation!");
        }
    }
}
