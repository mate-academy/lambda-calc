package core.basesyntax;

public class Calculator {

    public int calculate(char method, int a, int b) {
        switch (method) {
            case '+': return getSum(a, b);
            case '-': return getSubtraction(a,b);
            case '/': return getDifference(a, b);
            case '*': return getMultiplication(a, b);
            case '^': return getPower(a, b);
            default: throw new
                    NoSuchAOperationException("Method " + method + " doesn't exist!");
        }
    }

    private int getSum(int a, int b) {
        return a + b;
    }

    private int getSubtraction(int a, int b) {
        return a - b;
    }

    private int getMultiplication(int a, int b) {
        return a * b;
    }

    private int getPower(int a, int b) {
        return (int) Math.pow(a, b);
    }

    private int getDifference(int a, int b) {
        return a / b;
    }
}

