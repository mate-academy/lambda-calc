package core.basesyntax;

public class Calculator implements CalculatorService {

    @Override
    public double calculate(double firsValue, double secondValue, char operator) {
        switch (operator) {
            case '+' :
                return firsValue + secondValue;
            case '-' :
                return firsValue - secondValue;
            case '/' :
                if (secondValue == 0) {
                    throw new IncorrectDataEntryException("Value can`t be zero!");
                }
                return firsValue / secondValue;
            case '*' :
                return firsValue * secondValue;
            case '^' :
                return Math.pow(firsValue, secondValue);
            default:
                throw new IncorrectDataEntryException("Illegal such operator " + operator);
        }
    }
}
