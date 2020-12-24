package core.basesyntax;

public class Calculator {

    public double calculate(double first, double second, char operation) {
        double result;
        switch (operation) {
            case '+' :
                result = first + second;
                break;

            case '-' :
                result = first - second;
                break;

            case '*' :
                result = first * second;
                break;

            case '/' :
                result = first / second;
                break;

            case '^' :
                result = Math.pow(first, second);
                break;

            default:
                throw new RuntimeException("Incorrect operation");
        }
        if (Double.isFinite(result)) {
            return result;
        }
        throw new ArithmeticException("Result is NaN");
    }
}
