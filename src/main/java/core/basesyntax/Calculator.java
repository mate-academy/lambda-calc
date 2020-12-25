package core.basesyntax;

public class Calculator implements Calculable {
    @Override
    public double calculate(char operations, double firstValue, double secondValue) {
        switch (operations) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("You cannot divide by zero");
                }
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new ArithmeticException("Wrong Arithmetic operation!");
        }
    }
}
