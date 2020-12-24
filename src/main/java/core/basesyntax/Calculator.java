package core.basesyntax;

public class Calculator {
    public static double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                isInfinity(result);
                return result;
            case '-':
                result = number1 - number2;
                isInfinity(result);
                return result;
            case '*':
                result = number1 * number2;
                isInfinity(result);
                return result;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                result = number1 / number2;
                return result;
            case '^':
                if ((number1 <= 0 && (number2 > 0 && number2 < 1)
                        || (number1 == 0 && number2 < 0))) {
                    throw new ArithmeticException("Operation is impossible");
                }
                result = Math.pow(number1, number2);
                return result;
            default:
                throw new IllegalArgumentException("Wrong operation");
        }
    }

    private static void isInfinity(double value) {
        if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
    }
}
