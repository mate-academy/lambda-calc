package core.basesyntax;

public class Calculator {
    public double calculate(int value1, int value2, char operator) {
        switch (operator) {
            case '+': return (double) value1 + value2;
            case '-': return (double) value1 - value2;
            case '*': return (value1 == 0 || value2 == 0) ? 0 : (double) value1 * value2;
            case '/':
                if (value2 == 0) {
                    throw new ArithmeticException("You can't division by zero");
                }
                return (double) value1 / value2;
            case '^':
                if (value1 == 0 && value2 < 0) {
                    throw new ArithmeticException("You can't raising zero in negative power");
                }
                if (Double.isInfinite(Math.pow(value1, value2))) {
                    throw new ArithmeticException("ERROR!!! Large value!");
                }
                return Math.pow(value1, value2);
            default: throw new IncorrectOperationException("You try to do incorrect operation");
        }
    }
}
