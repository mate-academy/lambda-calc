package core.basesyntax;

public class Calculator {

    public static Double calculate(double firstVariable, double secondVariable, char sign) {
        if (secondVariable == 0 && sign == '/') {
            throw new ArithmeticException("Division by zero");
        }

        return (sign == '+') ? firstVariable + secondVariable :
                (sign == '*') ? firstVariable * secondVariable :
                        (sign == '/') ? firstVariable / secondVariable :
                                (sign == '-') ? firstVariable - secondVariable :
                                        (sign == '^') ? Math.pow(firstVariable, secondVariable)
                                                : null;
    }
}
