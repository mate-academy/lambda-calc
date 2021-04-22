package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operating) {
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
                return Math.pow(number1, number2);
            default:
                throw new RuntimeException("Wrong operator:" + operating);
        }
    }
}
