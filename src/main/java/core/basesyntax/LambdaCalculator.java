package core.basesyntax;

public class LambdaCalculator {
    public double calculate(int a, int b, char operator) {
        switch (operator) {
            case '+' : return (double) a + b;
            case '-' : return (double) a - b;
            case '*' : return (double) a * b;
            case '/' : if (b == 0) {
                    throw new ArithmeticException("You can't divide by zero!");
                }
                return (double) a / b;
            case '^' : return Math.pow(a, b);
            default: throw new ArithmeticException("Invalid operator");
        }
    }
}
