package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operator) {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("It can not be divided by 0...");
                }
                return number1 / number2;
            case '*':
                return number1 * number2;
            case '^':
                return Math.pow(number1, number2);
            default:
                throw new RuntimeException("It is not possible to provide such operation...");
        }
    }
}
