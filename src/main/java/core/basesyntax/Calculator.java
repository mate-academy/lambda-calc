package core.basesyntax;

public class Calculator {

    public static double calculate(double firstVariable, double secondVariable, char sign) {
        if (secondVariable == 0 && sign == '/') {
            throw new ArithmeticException("Division by zero");
        }

        if (sign == '+') {
            return firstVariable + secondVariable;
        }

        if (sign == '*') {
            return firstVariable * secondVariable;
        }

        if (sign == '/') {
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
