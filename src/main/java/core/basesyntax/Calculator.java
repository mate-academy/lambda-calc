package core.basesyntax;

public class Calculator implements Calculate {

    @Override
    public double calculate(double firstParameter, double secondParameter, char operation) {
        switch (operation) {
            case '+':
                return firstParameter + secondParameter;
            case '-':
                return firstParameter - secondParameter;
            case '*':
                return firstParameter * secondParameter;
            case '^':
                return Math.pow(firstParameter, secondParameter);
            case '/':
                if (secondParameter == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return firstParameter / secondParameter;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
