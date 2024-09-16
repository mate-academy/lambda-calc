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
            case '/':
                if (number2 == 0) {
                    throw new IllegalArgumentException("We can't division on zero");
                }
                return number1 / number2;
            case '^':
                if (number2 < 0 && number1 == 0) {
                    throw new IllegalArgumentException("We can't raising zero to negative numbers");
                }
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("We can't use this operator" + operation);
        }
    }
}
