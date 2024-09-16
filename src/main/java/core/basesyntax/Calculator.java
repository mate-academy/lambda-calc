package core.basesyntax;

public class Calculator implements CalculatorService {
    @Override
    public double calculate(double firstValue, double secondValue, char operationType) {
        switch (operationType) {
            case '+' : {
                return firstValue + secondValue;
            }
            case '-' : {
                return firstValue - secondValue;
            }
            case '*' : {
                return firstValue * secondValue;
            }
            case '/' : {
                if (firstValue != 0 && secondValue == 0) {
                    throw new IllegalArgumentException("Can't divide by zero!");
                }
                return firstValue / secondValue;
            }
            case '^' : {
                return Math.pow(firstValue, secondValue);
            }
            default: {
                throw new IllegalArgumentException("Illegal operation type");
            }
        }
    }
}
