package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, Character operation) {
        switch (operation) {
            case ('+') :
                return a + b;
            case ('-') :
                return a - b;
            case ('*') :
                return a * b;
            case ('/') :
                if (b == 0) {
                    throw new ArithmeticException("Dividing zero!");
                }
                return a / b;
            case ('^') :
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Illegal operation!");
        }
    }
}
