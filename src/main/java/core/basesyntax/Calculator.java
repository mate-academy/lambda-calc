package core.basesyntax;

public class Calculator {
    public static double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case '+':
                isMaxValue(number1, number2);
                return number1 + number2;
            case '-':

                return number1 - number2;
            case '*':
                isMaxValue(number1, number2);
                return number1 * number2;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                return number1 / number2;
            case '^':
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("Wrong operation");
        }
    }

    private static void isMaxValue(double number1, double number2) {
        if (number1 == Double.MAX_VALUE && number1 == number2) {
            throw new ArithmeticException("Infinity");
        }
    }
}
