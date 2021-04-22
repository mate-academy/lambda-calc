package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = a / b;
                break;
            case '^':
                result = Math.pow(a, b);
                break;
            default:
                throw new IllegalOperationException("Bad operator or operation is not supported");
        }
        return result;
    }

}
