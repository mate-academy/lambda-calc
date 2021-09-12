package core.basesyntax;

public class LambdaCalculator implements Calculate {

    @Override
    public double calculate(double a, double b, char operation) {
        double result;
        switch (operation) {
            case ('+') :
                result = a + b;
                break;
            case ('-') :
                result = a - b;
                break;
            case ('*') :
                if (a == 0 || b == 0) {
                    result = 0;
                } else {
                    result = a * b;
                }
                break;
            case ('/') :
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is an illegal operation");
                }
                result = a / b;
                break;
            case ('^') :
                result = Math.pow(a, b);
                break;
            default:
                throw new ArithmeticException("Operation" + operation + " is illegal");
        }
        return result;
    }
}
