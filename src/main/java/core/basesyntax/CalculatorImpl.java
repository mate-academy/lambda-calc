package core.basesyntax;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(double a, double b, char ch) throws ArithmeticException {
        double result;
        switch (ch) {
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
                    throw new ArithmeticException();
                } else {
                    result = a / b;
                    break;
                }
            case '^' :
                result = Math.pow(a,b);
                break;
            default:
                result = 0;
        }
        if (ch != '+' && ch != '-' && ch != '*'
                && ch != '/' && ch != '^') {
            throw new IllegalOperationException("This operation is not thought "
                    + "out for this calculator");
        }
        return result;
    }
}
