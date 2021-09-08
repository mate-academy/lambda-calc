package core.basesyntax;

public class Calculator {

    public double calculate(double x, double y, String operation) {
        switch (operation) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                if (y == 0) {
                    throw new ArithmeticException("Can't divide by zero...");
                }
                return x / y;
            case "^":
                return Math.pow(x, y);
            default:
                throw new InvalidOperationException("Invalid operation");
        }
    }
}
