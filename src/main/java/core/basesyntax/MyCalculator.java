package core.basesyntax;

public class MyCalculator implements Calculator {
    public double calculate(double a, double b, char sing) throws MyCalculateException {
        switch (sing) {
            case '*': {
                if (a * b >= Double.MAX_VALUE || a * b <= -Double.MAX_VALUE) {
                    throw new MyCalculateException("Too large or little result!");
                }
                return a * b;
            }
            case '/': {
                if (b == 0) {
                    throw new MyCalculateException("Can't be divided by zero!");
                }
                if (a / b >= Double.MAX_VALUE || a / b <= -Double.MAX_VALUE) {
                    throw new MyCalculateException("Too large or little result!");
                }
                return a / b;

            }
            case '+': {
                if (a + b >= Double.MAX_VALUE || a + b <= -Double.MAX_VALUE) {
                    throw new MyCalculateException("Too large or little result!");
                }
                return a + b;
            }
            case '-': {
                if (a - b >= Double.MAX_VALUE || a - b <= -Double.MAX_VALUE) {
                    throw new MyCalculateException("Too large or little result!");
                }
                return a - b;
            }
            case '^': {
                if (Math.pow(a, b) >= Double.MAX_VALUE || Math.pow(a, b) <= -Double.MAX_VALUE) {
                    throw new MyCalculateException(("Too large or little result!"));
                }
                return Math.pow(a, b);
            }
            default: {
                throw new MyCalculateException("A sing isn't correct!");
            }
        }
    }
}
