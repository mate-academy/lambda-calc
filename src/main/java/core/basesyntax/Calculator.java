package core.basesyntax;

public class Calculator {
    public double calculator(double value1, double value2, char operation) {
        switch (operation) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '/':
                return value1 / value2;
            case '*':
                return value1 * value2;
            case '^':
                return Math.pow(value1, value2);
            default:
                throw new RuntimeException("Wrong operation " + operation);
        }
    }
}
