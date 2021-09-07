package core.basesyntax;

public class Calculator implements Calc {

    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException();
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '^':
                double result = 1;
                for (int i = 1; i <= secondOperand; i++) {
                    result = result * firstOperand;
                }
                return result;
            default:
                throw new RuntimeException("such an operation is not possible" + operation);
        }
    }
}
