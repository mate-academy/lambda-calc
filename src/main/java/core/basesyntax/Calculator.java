package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    protected double calculate(double firstOperand, double secondOperand, char operationSymbol) {
        switch (operationSymbol) {
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("Division by zero is not possible!");
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new ArithmeticException("Operation is not correct!");
        }
    }
}
