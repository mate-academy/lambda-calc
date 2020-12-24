package core.basesyntax;

public class Calculator {
    public static double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                result = number1 / number2;
                break;
            case '^':
                if ((number1 <= 0 && (number2 > 0 && number2 < 1)
                        || (number1 == 0 && number2 < 0))) {
                    throw new ArithmeticException("Operation is impossible");
                }
                result = Math.pow(number1, number2);
                break;
            default:
                throw new IllegalArgumentException("Wrong operation");
        }
        if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        return result;
    }
}
