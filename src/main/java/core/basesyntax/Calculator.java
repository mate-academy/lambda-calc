package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                if (firstValue == Double.MAX_VALUE || secondValue == Double.MIN_VALUE) {
                    throw new ArithmeticException("Operand is illegal!");
                }
                return firstValue + secondValue;
            case '-':
                if (firstValue == -Double.MAX_VALUE || secondValue == -Double.MIN_VALUE) {
                    throw new ArithmeticException("Operand is illegal!");
                }
                return firstValue - secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("Operand is illegal!");
                }
                return firstValue / secondValue;
            case '*':
                if (firstValue == Double.MAX_VALUE || firstValue == -Double.MAX_VALUE
                        && secondValue != 0 || secondValue == Double.MIN_VALUE
                        || secondValue == -Double.MAX_VALUE && firstValue != 0) {
                    throw new ArithmeticException("Operand is illegal!");
                }
                return firstValue * secondValue;
            case '^':
                return firstValue < 0 && secondValue == 0 ? -Math.pow(firstValue, secondValue)
                        : Math.pow(firstValue, secondValue);
            default:
                throw new ArithmeticException("Operand is illegal!");
        }
    }
}
