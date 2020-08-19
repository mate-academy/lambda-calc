package core.basesyntax;

public class HelloWorld {
    public double calculate(double value1, double value2, char operation)
            throws BadOperandException {

        double result;

        switch (operation) {
            case ('*'):
                result = value1 * value2;
                break;
            case ('+'):
                result = value1 + value2;
                break;
            case ('-'):
                result = value1 - value2;
                break;
            case ('/'):
                if (value2 == 0) {
                    throw new ArithmeticException("You can't divide by zero");
                }
                result = value1 / value2;
                break;
            case ('^'):
                if (value1 == 0 && value2 < 0) {
                    throw new ArithmeticException("You can't divide by zero");
                }
                result = Math.pow(value1, value2);
                break;
            default:
                throw new BadOperandException("Bad operand");
        }
        return result;
    }
}
