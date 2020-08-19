package core.basesyntax;

public class SimpleCalculator {

    public double calculate(double a, Character sign, double b) {
        if (sign == '+') {
            return (a + b);
        }

        if (sign == '-') {
            return (a - b);
        }

        if (sign == '*' || sign == '•') {
            return (a * b);
        }

        if (sign == '/' || sign == ':') {
            if (b == 0) {
                throw new ArithmeticException("Division by zero exception");
            }
            return a / b;
        }

        if (sign == '^') {
            return Math.pow(a, b);
        }
        throw new IllegalArgumentException("\'" + sign + "\' is unknown operator");
    }
}
