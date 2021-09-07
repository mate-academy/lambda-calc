package core.basesyntax;

public class Calculator {

    public double calculate(double value1, double value2, char operation) {
        if (operation == '+') {
            return value1 + value2;
        }

        if (operation == '-') {
            return value1 - value2;
        }

        if (operation == '/') {
            return value1 / value2;
        }

        if (operation == '*') {
            return value1 * value2;
        }

        if (operation == '^') {
            double result = 1;
            for (int i = 1; i <= value2; i++) {
                result = result * value1;
            }
            return result;
        }
        return 0;
    }
}
