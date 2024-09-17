package core.basesyntax;

public class LambdaCalculator implements Calculator {

    @Override
    public double calculate(double firstParameter, double secondParameter, char operation) {
        switch (operation) {
            case '+':
                return firstParameter + secondParameter;
            case '*':
                return firstParameter * secondParameter;
            case '/':
                if (secondParameter == 0) {
                    throw new ArithmeticException("division by zero!");
                }
                return firstParameter / secondParameter;
            case '-':
                return firstParameter - secondParameter;
            case '^':
                return Math.pow(firstParameter, secondParameter);
            default:
                throw new IllegalOperationException("Unexpected operation" + operation);
        }
    }
}
