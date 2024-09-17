package core.basesyntax;

public class Calculator {
    public double calculate(double firstArgument, double secondArgument, char operation) {
        switch (operation) {
            case '+':
                return firstArgument + secondArgument;
            case '-':
                return firstArgument - secondArgument;
            case '/':
                if (secondArgument == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return firstArgument / secondArgument;
            case '*':
                return firstArgument * secondArgument;
            case '^':
                return Math.pow(firstArgument, secondArgument);
            default:
                throw new RuntimeException("No such operation! [ " + operation + "]");
        }
    }
}
