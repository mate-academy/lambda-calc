package core.basesyntax;

public class MyCalculator implements Calculator {
    @Override
    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new IllegalArgumentException("division by zero");
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("does not support '"
                        + operation + "' operation");
        }
    }
}
