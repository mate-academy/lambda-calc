package core.basesyntax.calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(double one, double two, char symbol) {
        switch (symbol) {
            case ('+') : return one + two;
            case ('-') : return one - two;
            case ('*') : return one * two;
            case ('/') : return one / two;
            case ('^') : return Math.pow(one, two);
            default: throw new IllegalOperationException("Symbol is not correct!");
        }
    }
}
