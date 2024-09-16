package core.basesyntax;

public class Calculator {

    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException();
                }
                return firstOperand / secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new RuntimeException("Operation char is invalid!");
        }
    }
}

