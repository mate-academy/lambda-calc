package core.basesyntax;

public class Calculator implements Calculation {
    @Override
    public double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            case '^':
                return Math.pow(number1, number2);
            default:
                throw new IllegalOperationException("Illegal operator");
        }
    }
}
