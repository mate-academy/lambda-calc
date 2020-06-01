package core.basesyntax;

public class Calculator {
    public double calculate(double x, double y, char o) {
        MathOperation addition = Double::sum;
        MathOperation subtraction = (x1, y1) -> x1 - y1;
        MathOperation multiplication = (x1, y1) -> x1 * y1;
        MathOperation division = (x1, y1) -> x1 / y1;
        MathOperation exponentiation = Math::pow;
        if (o == '+') {
            return addition.calculate(x, y);
        }
        if (o == '-') {
            return subtraction.calculate(x, y);
        }
        if (o == '*') {
            return multiplication.calculate(x, y);
        }
        if (o == '/') {
            return division.calculate(x, y);
        }
        if (o == '^') {
            return exponentiation.calculate(x, y);
        }
        throw new IllegalArgumentException();
    }
}
