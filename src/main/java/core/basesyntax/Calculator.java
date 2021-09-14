package core.basesyntax;

public class Calculator {
    public double calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new IllegalArgumentException();
                }
                return operand1 / operand2;
            case '^':
                if (operand1 == 0 && operand2 <= 0) {
                    throw new IllegalArgumentException();
                }
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException();
        }
    }
}
