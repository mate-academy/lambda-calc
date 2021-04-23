package core.basesyntax;

public class Calculator {
    public double calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+' :
                return operand1 + operand2;
            case '-' :
                return operand1 - operand2;
            case '*' :
                return operand1 * operand2;
            case '/' :
                if (operand2 == 0) {
                    throw new ArithmeticException("You can't divide by zero!");
                }
                return operand1 / operand2;
            case '^' :
                return Math.pow(operand1, operand2);
            default :
                throw new RuntimeException("This operation is illegal!");
        }
    }
}
