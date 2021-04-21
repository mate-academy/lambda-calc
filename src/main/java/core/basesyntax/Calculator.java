package core.basesyntax;

public class Calculator {
    public double calculator(double number1, double number2, char operating) {
        switch (operating) {
            case '+':
                return number1 + number2;

            case '-':
                return number1 - number2;

            case '/':
                return number1 / number2;
            case '*':
                return number1 * number2;
            case '^':
                if (number1 < 0) {
                    return Math.pow(number1 * -1, number2) * -1;
                }
                return Math.pow(number1, number2);
            default:
                throw new RuntimeException("Wrong operator");
        }
    }
}
