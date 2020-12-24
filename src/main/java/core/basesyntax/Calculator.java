package core.basesyntax;

public class Calculator implements Calculable {

    public double calculate(double first, double second, char operation) {
        double result;
        switch (operation) {
            case '+' :
                result = add(first, second);
                break;
            case '-' :
                result = subtract(first, second);
                break;
            case '/' :
                result = divide(first, second);
                break;
            case '*' :
                result = multiply(first, second);
                break;
            case '^' :
                result = power(first, second);
                break;
            default: throw new IllegalArgumentException("Wrong operation");
        }
        if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Result Overflow with operation " + operation);
        }
        return result;
    }

    private double add(double first, double second) {
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }

    private double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Division by zero is prohibited");
        }
        return first / second;
    }

    private double multiply(double first, double second) {
        return first * second;
    }

    private double power(double first, double second) {
        if (first == 0 && second < 0) {
            throw new ArithmeticException("Zero power negative is prohibited");
        }
        if (first < 0 && second > 0 && second < 1) {
            throw new ArithmeticException("Negative power fractional is prohibited");
        }
        return Math.pow(first, second);
    }
}
