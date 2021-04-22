package core.basesyntax;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operation) {
        operation = Character.toLowerCase(operation);
        if (operation == 'a') {
            return firstOperand + secondOperand;
        }
        if (operation == 's') {
            return firstOperand - secondOperand;
        }
        if (operation == 'd') {
            if (secondOperand == 0.0) {
                throw new ArithmeticException("Illegal operation: division by zero");
            }
            return firstOperand / secondOperand;
        }
        if (operation == 'm') {
            return firstOperand * secondOperand;
        }
        if (operation == 'p') {
            return Math.pow(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException("Operation symbol is not valid");
    }
}
