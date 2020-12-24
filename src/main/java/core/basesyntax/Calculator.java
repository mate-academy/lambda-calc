package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, String operation) {
        switch (operation) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                if (secondValue == 0) {
                    throw new ArithmeticException("You can't division on zero!");
                }
                return firstValue / secondValue;
            case "^":
                return Math.pow(firstValue, secondValue);
            default:
                throw new ArithmeticException("You type wrong operator, plz try again");
        }
    }
}
