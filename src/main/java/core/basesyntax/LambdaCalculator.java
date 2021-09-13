package core.basesyntax;

public class LambdaCalculator implements Calculate {
    @Override
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case ('+') :
                return a + b;
            case ('-') :
                return a - b;
            case ('*') :
                if (a == 0 || b == 0) {
                    return 0;
                } else {
                    return a * b;
                }
            case ('/') :
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is an illegal operation");
                }
                return a / b;
            case ('^') :
                return Math.pow(a, b);
            default:
                throw new ArithmeticException("Division by zero is an illegal operation");
        }
    }
}
