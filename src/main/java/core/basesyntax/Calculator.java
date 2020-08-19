package core.basesyntax;

public class Calculator {

    public double calculate(double x, double y, char operation) {
        if (operation == '/' && y == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        if (operation != '+'
                && operation != '-'
                && operation != '/'
                && operation != '^'
                && operation != '*') {
            throw new IllegalArgumentException("Wrong operator");
        }
        try {
            return operation == '+' ? x + y
                    : operation == '-' ? x - y
                    : operation == '*' ? x * y
                    : operation == '/' ? x / y
                    : operation == '^' ? Math.pow(x, y) : 0;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}
