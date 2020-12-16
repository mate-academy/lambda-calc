package core.basesyntax;

public class Calculator {
    public double calculate(int a, int b, char operate) {
        if (String.valueOf(operate).matches("[^*/+\\-^]")) {
            throw new IncorrectOperationException("You try to do incorrect operation");
        }
        if (b == 0 && operate == '/') {
            throw new ArithmeticException("You can't division by zero");
        }
        switch (operate) {
            case '+': return (double) a + b;
            case '-': return (double) a - b;
            case '*': return (double) a * b;
            case '/': return (double) a / b;
            case '^': return Math.pow(a, b);
            default: return 0.0;
        }
    }
}
