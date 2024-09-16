package core.basesyntax;

public class Calculator implements CalculatorService {
    @Override
    public double calculate(double firstValue, double secondValue, char operator) {
        switch (operator) {
            case '+' :
                return firstValue + secondValue;
            case '-' :
                return firstValue - secondValue;
            case '/' :
                if (secondValue == 0) {
                    throw new ArithmeticException("Value can`t be zero!");
                }
                return firstValue / secondValue;
            case '*' :
                return firstValue * secondValue;
            case '^' :
                return Math.pow(firstValue, secondValue);
            default:
                throw new IncorrectDataEntryException("Illegal such operator " + operator);
        }
    }
}
