package core.basesyntax;

public class Calculator implements SimpleCalculator {

    @Override
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new RuntimeException("Can`t division by zero");
                }
                return firstValue / secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalOperationException("Illegal operation");
        }
    }
}
