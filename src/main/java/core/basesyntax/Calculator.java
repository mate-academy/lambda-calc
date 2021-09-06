package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operation) {
        if (operation == '+') {
            return a + b;
        }

        if (operation == '-') {
            return a - b;
        }

        if (operation == '/') {
            return a / b;
        }

        if (operation == '*') {
            return a * b;
        }

        if (operation == '^') {
            double result = 1;
            for (int i = 1; i <= b; i++) {
                result = result * a;
            }
            return result;
        }
        return 0;
    }
}
