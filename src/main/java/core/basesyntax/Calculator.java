package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public static Integer startCalc(int a, int b, char sign) {
        switch (sign) {
            case ('-'):
                return a - b;
            case ('+'):
                return a + b;
            case ('*'):
                return a * b;
            case ('/'):
                if (b != 0) {
                    return a / b;
                } else {
                    throw new IllegalArgumentException("Can't divide by zero!");
                }
            case ('^'):
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Error! Wrong operator!");
        }
    }
}
