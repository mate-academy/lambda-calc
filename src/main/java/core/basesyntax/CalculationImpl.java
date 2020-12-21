package core.basesyntax;

public class CalculationImpl implements Calculation {
    @Override
    public double calculate(int a, int b, char operation) {
        switch (operation) {
            case '+':
                return (double) a + b;
            case '-':
                return (double) a - b;
            case '*':
                return (double) a * b;
            case '/':
                if (b != 0) {
                    return (double) a / b;
                }
                throw new ArithmeticException("You cannot divide by zero!");
            case '^':
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Arithmetic operation symbol was entered incorrectly!");
        }
    }
}
