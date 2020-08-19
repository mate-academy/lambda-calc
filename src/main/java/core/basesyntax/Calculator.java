package core.basesyntax;

public class Calculator {

    public double calculate(double x, double y, char operation) {
        if (operation == '/' && y == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        switch (operation) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '^':
                return Math.pow(x, y);
            default:
                throw new IllegalArgumentException("Wrong operator");
        }
    }
}
