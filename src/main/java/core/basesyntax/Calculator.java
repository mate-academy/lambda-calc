package core.basesyntax;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                result = firstOperand / secondOperand;
                break;
            case '^':
                result = 1;
                if (secondOperand >= 0) {
                    for (int i = 0; i < secondOperand; i++) {
                        result *= firstOperand;
                    }
                } else {
                    for (int i = 0; i < secondOperand * -1; i++) {
                        result /= firstOperand;
                    }
                }
                break;
            default:
                throw new NoSuchOperationException("Operation is unknown!");
        }
        return result;
    }
}
