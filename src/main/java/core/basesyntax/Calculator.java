package core.basesyntax;

public class Calculator {

    public Integer result(Character method, int a, int b) {
        switch (method) {
            case '+': return getSum(a, b);
            case '-': return getSubtraction(a,b);
            case '/': return getDifference(a, b);
            case '*': return getMultiplication(a, b);
            case '^': return getPower(a, b);
            default: throw new
                    NoSuchArgument("Method " + method + " doesn't exist!");
        }
    }

    public Integer getSum(int a, int b) {
        return a + b;
    }

    public int getSubtraction(int a, int b) {
        return a - b;
    }

    public int getMultiplication(int a, int b) {
        return a * b;
    }

    public int getPower(int a, int b) {
        return (int) Math.pow(a, b);
    }

    public int getDifference(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Can't delete by zero!");
        }
        return a / b;
    }
}

