package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case '+': {
                return number1 + number2;
            }
            case '-': {
                return number1 - number2;
            }
            case '*': {
                return number1 * number2;
            }
            case '/': {
                if (number2 == 0) {
                    throw new ArithmeticException("Division by 0");
                }
                return number1 / number2;
            }
            case '^': {
                return Math.pow(number1, number2);
            }
            default: {
                throw new UnsupportedOperationException("This operator is not supported "
                        + operation);
            }
        }
    }
}
