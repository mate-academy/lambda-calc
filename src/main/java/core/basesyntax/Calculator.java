package core.basesyntax;

public class Calculator {
    public double calculator(double value1, double value2, char operation) {
        switch (operation) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '/':
                if (value2 == 0) {
                    throw new ArithmeticException("We can not divide any number by 0");
                } else {
                    return value1 / value2;
                }
            case '*':
                return value1 * value2;
            case '^':
                if (value1 < 0 && value2 % 1 != 0) {
                    throw new ArithmeticException("We can not raise a negative number to "
                            + "a fractional power");
                }
                return Math.pow(value1, value2);
            default:
                throw new RuntimeException("No operation");
        }
    }
}
