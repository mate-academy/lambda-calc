public class Calculator {
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("The second argument can't be zero.");
                }
                return a / b;

            case '*':
                return a * b;

            case '^':
                return Math.pow(a, b);

            default:
                throw new IllegalArgumentException("Operation is invalid.");
        }
    }
}
