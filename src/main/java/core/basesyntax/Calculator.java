package core.basesyntax;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE + Double.MAX_VALUE);
    }

    public double calculate(double first, double second, char operator) {
        switch (operator) {
            case '+': {
                return first + second;
            }
            case '-': {
                return first - second;
            }
            case '*': {
                return first * second;
            }
            case '/': {
                if (second == 0) {
                    throw new ArithmeticException();
                }
                return first / second;
            }
            default:
            case '^': {
                return Math.pow(first, second);
            }
        }
    }
}
