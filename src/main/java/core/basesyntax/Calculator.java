package core.basesyntax;

public class Calculator implements Calculable {

    @Override
    public double calculate(int x, int y, String operation) {
        switch (operation) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return (double)x * (double)y;
            case "/":
                if (y == 0) {
                    throw new ArithmeticException("You cannot divide by zero");
                }
                return x / y;
            case "^":
                return Math.pow(x, y);
            default:
                throw new RuntimeException("Operation not supported");
        }
    }
}
