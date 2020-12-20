package core.basesyntax;

public class Calculator {
    public double calculate(int a, int b, char operate) {
        if (b == 0 && operate == '/') {
            throw new ArithmeticException("You can't division by zero");
        }
        switch (operate) {
            case '+': return (double) a + b;
            case '-': return (double) a - b;
            case '*': return (double) a * b;
            case '/': return (double) a / b;
            case '^': return Math.pow(a, b);
            default: throw new IncorrectOperationException("You try to do incorrect operation");
        }
    }
}
