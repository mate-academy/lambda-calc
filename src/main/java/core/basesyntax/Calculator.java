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
                if (firstParameter == 0 && secondParameter < 0) {
                    throw new IllegalArgumentException(
                            "Power zero to negative value is not allowed.");
                }
                return Math.pow(firstParameter, secondParameter);
            case '/':
                if (secondParameter == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return firstParameter / secondParameter;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
