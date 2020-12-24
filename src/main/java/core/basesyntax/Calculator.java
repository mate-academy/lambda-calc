package core.basesyntax;

public class Calculator {
    public int calculate(int a, int b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (isZero(b)) {
                    throw new RuntimeException("Can't divide by zero");
                }
                return a / b;
            case '^':
                return (int) Math.pow(a, b);
            default:
                throw new RuntimeException("Unknown operation");
        }
    }

    private boolean isZero(int item) {
        return item == 0;
    }
}
