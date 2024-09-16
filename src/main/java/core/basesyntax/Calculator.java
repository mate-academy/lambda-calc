package core.basesyntax;

public class Calculator {
    public double calculate(double a, Character operator, double b) {
        if (!operator.toString().matches("[-+*/^]")) {
            throw new IllegalArgumentException("Operator not found");
        }
        if (b == 0 && operator == '/') {
            throw new ArithmeticException("Can`t divide by zero");
        }
        return operator == '+' ? a + b : operator == '-' ? a - b :
                operator == '*' ? a * b : operator == '/' ? a / b :
                        Math.pow(a, b);
    }
}
