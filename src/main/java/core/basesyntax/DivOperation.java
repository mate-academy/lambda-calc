package core.basesyntax;

public class DivOperation implements ArithmeticOperation {

    @Override
    public double action(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Сannot be divided by zero!!!");
        }
        return a / b;
    }
}
