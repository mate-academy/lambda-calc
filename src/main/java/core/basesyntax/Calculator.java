package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    double calculate(double firstOperand, double secondOperand, char sign) {
        switch (sign) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("divide by zero");
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new RuntimeException("Wrong sign " + sign);
        }
    }
}
