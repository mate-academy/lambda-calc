package core.basesyntax;

public class LambdaCalc {
    public double calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0 || operand2 == -0) {
                    throw new RuntimeException("Division by zero result cannot be provided");
                }
                return operand1 / operand2;
            case '^':
                if ((operand1 == 0 || operand1 == -0) && operand2 < 0) {
                    throw new RuntimeException("Zero in negative pow cannot be provided");
                }
                return Math.pow(operand1, operand2);
            default:
                throw new RuntimeException("Operation type not supported");
        }
    }
}
