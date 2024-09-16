package core.basesyntax;

public class Calculator implements CalculatorValidator {
    @Override
    public double calculate(double first, double second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                if (first == Double.MAX_VALUE || second == Double.MAX_VALUE) {
                    throw new ArithmeticException("Invalid value");
                }
                return first * second;
            case "/":
                if (second == 0) {
                    throw new ArithmeticException("Division by zero error");
                }
                return first / second;
            case "^":
                return Math.pow(first, second);
            default:
                throw new ArithmeticException("Operator must be selected");
        }
    }
}
