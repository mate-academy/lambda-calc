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
                if (secondValue == 0) {
                    throw new ArithmeticException("Division on 0 is banned!");
                }
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }
}
