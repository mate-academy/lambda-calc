package core.basesyntax;

public class Calculator {
    public double calculate(double value1, double value2, char operation) {

        switch (operation) {
            case ('*'):
                return value1 * value2;
            case ('+'):
                return value1 + value2;
            case ('-'):
                return value1 - value2;
            case ('/'):
                if (value2 == 0) {
                    throw new ArithmeticException("You can't divide by zero");
                }
                return value1 / value2;
            case ('^'):
                if (value1 == 0 && value2 < 0) {
                    throw new ArithmeticException("You can't divide by zero");
                } else if (value1 < 0 && value2 % 2 == 0) {
                    throw new ArithmeticException("You can't take a paired "
                            + "root of a negative number");
                }
                return Math.pow(value1, value2);
            default:
                throw new BadOperandException("Bad operand");
        }
    }
}
