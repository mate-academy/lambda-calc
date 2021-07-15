package core.basesyntax;

public class MyCalculator implements Calculator {
    @Override
    public double calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return (operand1 == 0 || operand2 == 0 ? 0 : operand1 * operand2);
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                return (operand1 == 0 && operand2 < 0 ? 0 : operand1 / operand2);
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new RuntimeException("Unknown operation " + operation);
        }
    }
}
