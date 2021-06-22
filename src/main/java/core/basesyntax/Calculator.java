package core.basesyntax;

public class Calculator {

    public double calculate(double firstArg, double secondArg, char operator) {
        switch (operator) {
            case '+':
                return firstArg + secondArg;
            case '-':
                return firstArg - secondArg;
            case '/':
                if (secondArg == 0) {
                    throw new ArithmeticException("Dividing by zero!");
                }
                return firstArg / secondArg;
            case '*':
                return firstArg * secondArg;
            case '^':
                return Math.pow(firstArg, secondArg);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operator);
        }
    }
}
