package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '^':
                return Math.pow(number1, number2);
            case '/':
                if (number2 == 0) {
                    throw new IllegalArgumentException("Can't divide by zero");
                }
                return number1 / number2;
            default:
                throw new IllegalStateException("Invalid operation");
        }
    }
}
