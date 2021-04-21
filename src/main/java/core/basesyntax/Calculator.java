package core.basesyntax;

public class Calculator implements Calculate {

    @Override
    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '^':
                return Math.pow(a, b);
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("You can't divide by 0");
                }
                return a / b;
            default:
                throw new RuntimeException("Unsupported operator");
        }
    }
}
