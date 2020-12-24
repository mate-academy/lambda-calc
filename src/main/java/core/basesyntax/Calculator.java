package core.basesyntax;

public class Calculator {
    public double calculate(int arg1, int arg2, char operation) {
        switch (operation) {
            case '+':
                return arg1 + arg2;
            case '-':
                return arg1 - arg2;
            case '*':
                return arg1 * arg2;
            case '/':
                if (arg2 == 0) {
                    throw new RuntimeException("Can't divide by zero");
                }
                return (double) arg1 / arg2;
            case '^':
                return Math.pow(arg1, arg2);
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
