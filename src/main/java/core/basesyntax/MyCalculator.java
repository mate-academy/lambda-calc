package core.basesyntax;

public class MyCalculator implements Calculator {
    @Override
    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case '+':
                if (firstOperand + secondOperand >= Double.MAX_VALUE) {
                    throw new IllegalArgumentException("Operands values are too high!");
                }
                return firstOperand + secondOperand;
            case '-':
                if (firstOperand - secondOperand >= Double.MAX_VALUE) {
                    throw new IllegalArgumentException("Operands values are too high!");
                }
                return firstOperand - secondOperand;
            case '/':
                if (firstOperand / secondOperand >= Double.MAX_VALUE) {
                    throw new IllegalArgumentException("Operands values are too high!");
                }
                if (secondOperand == 0) {
                    throw new IllegalArgumentException("division by zero");
                }
                return firstOperand / secondOperand;
            case '*':
                if (firstOperand * secondOperand >= Double.MAX_VALUE) {
                    throw new IllegalArgumentException("Operands values are too high!");
                }
                return firstOperand * secondOperand;
            case '^':
                if (Math.pow(firstOperand, secondOperand) >= Double.MAX_VALUE) {
                    throw new IllegalArgumentException("Operands values are too high!");
                }
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("does not support '"
                        + operation + "' operation");
        }
    }
}
