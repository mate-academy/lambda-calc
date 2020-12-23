package core.basesyntax;

public class Calculator implements ArithmeticalOperator {

    @Override
    public double calculate(ArithmeticOperators operations, double firstValue, double secondValue) {
        switch (operations) {
            case ADDITION:
                return firstValue + secondValue;
            case SUBTRACTION:
                return firstValue - secondValue;
            case DIVISION:
                if (secondValue == 0) {
                    throw new ArithmeticException("You cannot divide by zero");
                }
                return firstValue / secondValue;
            case MULTIPLICATION:
                return firstValue * secondValue;
            case RISING_TO_POWER:
                return Math.pow(firstValue, secondValue);
            default:
                throw new ArithmeticException("Wrong Arithmetic operation!");
        }
    }
}
