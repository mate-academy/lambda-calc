package core.basesyntax;

public class MyCalculator {

    public double calculate(double a, double b, char operation) {
        Double.valueOf(a);
        Double.valueOf(b);
        Character.valueOf(operation);
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Wrong operator" + operation);
        }
    }
}
