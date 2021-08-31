package core.basesyntax.calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(double one, double two, char symbol) {
        if (two == 0 && symbol == '/') {
            throw new ArithmeticException("Division by zero is not possible");
        }
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
