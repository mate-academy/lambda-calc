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
                return firsValue / secondValue;
            case '*' :
                return firsValue * secondValue;
            case '^' :
                return Math.pow(firsValue, secondValue);
            default:
                throw new IllegalArgumentException("Illegal such operator " + operator);
        }
    }
}
