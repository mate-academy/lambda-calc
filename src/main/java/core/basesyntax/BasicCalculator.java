package core.basesyntax;

public class BasicCalculator {

    public double calculus(double arg1, double arg2, char operand) throws CalcException {

        switch (operand) {
            case '+': {
                return arg1 + arg2;
            }
            case '-': {
                return arg1 - arg2;
            }
            case '*': {
                return arg1 * arg2;
            }
            case '/': {
                if (arg2 == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                return arg1 / arg2;
            }
            case '^': {
                return Math.pow(arg1, arg2);
            }
            default:
                throw new CalcException("Incorrect operand " + operand);
        }
    }
}
