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
                return divide(firstOperand, secondOperand);
            case '^':
                return raiseValueToPower(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("Operation " + operation
                        + " is not allowed. Please input operation from +, - , *, /, ^ ");
        }
    }

    private double divide(double firstOperand, double secondOperand) {
        if (secondOperand == Double.NEGATIVE_INFINITY
                || secondOperand == Double.POSITIVE_INFINITY || secondOperand == 0) {
            throw new ArithmeticException("ArithmeticException is occured. "
                    + " Divider must not be 0.");
        }
        return firstOperand / secondOperand;
    }

    private double raiseValueToPower(double firstOperand, double power) {
        if (firstOperand == 0 && power <= 0) {
            throw new IllegalArgumentException("IllegalArgumentException is occured."
                    + " Power must be > 0. ");
        }
        return Math.pow(firstOperand, power);
    }
}
