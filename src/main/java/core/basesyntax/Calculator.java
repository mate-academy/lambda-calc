package core.basesyntax;

public class Calculator implements Calculable {
    @Override
    public double calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case '+':
                return (double) firstOperand + secondOperand;
            case '-':
                return (double) firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (double) firstOperand / secondOperand;
            case '*':
                return (double) firstOperand * secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new RuntimeException("ERROR impossible operand detected: " + operator);
        }
    }
}
