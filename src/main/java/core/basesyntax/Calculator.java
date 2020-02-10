package core.basesyntax;

public class Calculator {
    public double calculate(double a, char operator, double b) {
        if (a == 0 && operator == '/') {
            throw new ArithmeticException();
        }
            return operator == '+' ? a + b : operator == '-' ? a - b :
                    operator == '*' ? a * b : operator == '/' ? a / b :
                            operator == '^' ? Math.pow(a, b) : null;
    }
}
