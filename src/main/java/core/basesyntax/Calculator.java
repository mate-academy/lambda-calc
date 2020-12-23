package core.basesyntax;

public class Calculator {
    public double calculate(int a, int b, char operate) {
        switch (operate) {
            case '+': return (double) a + b;
            case '-': return (double) a - b;
            case '*': return ((a == 0 || b == 0) ? 0 : (double) a * b);
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("You can't division by zero");
                }
                return (double) a / b;
            case '^':
                if (a == 0 && b < 0) {
                    throw new ArithmeticException("You can't raising zero in negative power");
                }
                return Math.pow(a, b) > Double.MAX_VALUE ? Double.MAX_VALUE : Math.pow(a, b);
            default: throw new IncorrectOperationException("You try to do incorrect operation");
        }
    }
}
