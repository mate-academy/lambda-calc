package core.basesyntax;

public class Calculator {

    public static double calculate(double firstVariable, double secondVariable, char sign) {
        if (sign == '+') {
            return firstVariable + secondVariable;
        }

        if (sign == '*') {
            return firstVariable * secondVariable;
        }

        if (sign == '/') {
            if (secondVariable == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return firstVariable / secondVariable;
        }

        if (sign == '-') {
            return firstVariable - secondVariable;
        }

        if (sign == '^') {
            return Math.pow(firstVariable, secondVariable);
        }

        throw new IllegalArgumentException(sign + " isn't exit operation.");
    }
}
