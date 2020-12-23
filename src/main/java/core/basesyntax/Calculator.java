package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, String operation) {
        if (operation.equals("+")) {
            return firstValue + secondValue;
        }
        if (operation.equals("-")) {
            return firstValue - secondValue;
        }
        if (operation.equals("*")) {
            return firstValue * secondValue;
        }
        if (operation.equals("/")) {
            if (secondValue == 0) {
                throw new ArithmeticException("You can't division on zero!");
            }
            return firstValue / secondValue;
        }
        if (operation.equals("^")) {
            return Math.pow(firstValue, secondValue);
        }

        throw new ArithmeticException("You type wrong operator, plz try again");
    }
}
