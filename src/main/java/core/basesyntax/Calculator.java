package core.basesyntax;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operation) {
        if (operation == '+') {
            return firstOperand + secondOperand;
        }
        if (operation == '-') {
            return firstOperand - secondOperand;
        }
        if (operation == '/') {
            if (secondOperand == 0) {
                throw new ArithmeticException("Illegal operation: "
                        + "division by zero is not permitted");
            }
            return firstOperand / secondOperand;
        }
        if (operation == '*') {
            return firstOperand * secondOperand;
        }
        if (operation == '^') {
            if (firstOperand < 0 && secondOperand % 1 != 0) {
                throw new ArithmeticException("Illegal operation: "
                        + "raising negative number to fractional power is not permitted");
            }
            if (firstOperand == 0 && secondOperand < 0) {
                throw new ArithmeticException("Illegal operation: "
                        + "raising zero to negative power is not permitted");
            }
            return Math.pow(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException("Operation symbol is not valid");
    }
}
