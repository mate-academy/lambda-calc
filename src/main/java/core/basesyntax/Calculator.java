package core.basesyntax;

public class Calculator implements LambdaCalculate {

    @Override
    public double lambdaCalculator(
            double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                if (firstValue == 0) {
                    return 0;
                }
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }
}
