package core.basesyntax;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(double a, double b, char operand) {
        switch (operand) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                if (a == 0 || b == 0) {
                    return 0;
                }
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Can`t divide by 0");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Bad type of argument");
        }
    }
}
