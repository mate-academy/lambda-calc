package core.basesyntax;

public class Calculator {
    public int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+": return add(a, b);
            case "-": return sub(a, b);
            case "/": return div(a, b);
            case "*": return mul(a, b);
            case "^": return pow(a, b);
            default: throw new IllegalArgumentException();
        }
    }

    private int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }

    private int mul(int a, int b) {
        return a * b;
    }

    private int div(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    private int sub(int a, int b) {
        return a - b;
    }

    private int add(int a, int b) {
        return a + b;
    }
}
