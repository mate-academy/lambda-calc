package core.basesyntax;

public class Calculator implements Calculate {
    @Override
    public double calculate(double nub1, double nub2, char operation) {
        switch (operation) {
            case '+':
                return nub1 + nub2;
            case '-':
                return nub1 - nub2;
            case '*':
                return nub1 * nub2;
            case '/':
                if (nub2 == 0) {
                    throw new ArithmeticException("Values are equal 0. Try again");
                }
                return nub1 / nub2;
            case '^':
                if (nub1 == 0 && nub2 < 0) {
                    throw new ArithmeticException(
                            "First value equal 0 and second less than 0. Try again");
                }
                return Math.pow(nub1, nub2);
            default:
                throw new IllegalArgumentException("You wrote a different type. Try again");
        }
    }
}
