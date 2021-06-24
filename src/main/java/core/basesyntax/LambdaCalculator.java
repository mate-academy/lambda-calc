package core.basesyntax;

public class LambdaCalculator {
    public double calculate(double number1, double number2, char operator) {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by ZERO");
                }
                return number1 / number2;
            case '*':
                return number1 * number2;
            case '^':
                return Math.pow(number1, number2);
            default:
                throw new IllegalArgumentException("Wrong operator type");
        }
    }
}
