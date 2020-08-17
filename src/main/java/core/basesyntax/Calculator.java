package core.basesyntax;

public class Calculator {
    private static double x;
    private static double y;
    private static char operation;

    public Calculator(double x, double y, char operation) {
        Calculator.x = x;
        Calculator.y = y;
        Calculator.operation = operation;
    }

    public double calculate() {
        if (operation == '/' && y == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return operation == '+' ? x + y
                : operation == '-' ? x - y
                : operation == '*' ? x * y
                : operation == '/' ? x / y
                : operation == '^' ? Math.pow(x, y) : 0;
    }
}
