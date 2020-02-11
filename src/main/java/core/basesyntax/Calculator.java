package core.basesyntax;

public class Calculator {
    public double calculate(double a, Character operator, double b) {
        if (!operator.toString().matches("[-+*/^]") || b == 0 && operator == '/') {
            throw new ArithmeticException();
        }
        return operator == '+' ? a + b : operator == '-' ? a - b :
                operator == '*' ? a * b : operator == '/' ? a / b :
                        Math.pow(a, b);
    }
}
