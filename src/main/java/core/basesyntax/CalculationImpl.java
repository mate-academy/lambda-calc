package core.basesyntax;

public class CalculationImpl implements Calculation {
    @Override
    public double calculate(int firstValue, int secondValue, char operation) {
        switch (operation) {
            case '+':
                return (double) firstValue + secondValue;
            case '-':
                return (double) firstValue - secondValue;
            case '*':
                return (double) firstValue * secondValue;
            case '/':
                if (secondValue != 0) {
                    return (double) firstValue / secondValue;
                }
                throw new ArithmeticException("You cannot divide by zero!");
            case '^':
                if (secondValue == Integer.MAX_VALUE) {
                    throw new ArithmeticException("You cannot bring such a large number!");
                }
                if (secondValue < 0) {
                    throw new ArithmeticException("Degree cannot be negative!");
                }
                return Math.pow(firstValue, secondValue);
            default:
                throw new RuntimeException("Arithmetic operation symbol was entered incorrectly!");
        }
    }
}
