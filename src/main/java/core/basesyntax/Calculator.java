package core.basesyntax;

public class Calculator {
    public double calculate(double first, char operation, double second) {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first == 0 || second == 0 ? 0 : first * second;
            case '/':
                if (second == 0) {
                    throw new ArithmeticException("Sorry, I can't divide on zero");
                }
                return first / second;
            case '^':
                if (first == 0 && second < 0) {
                    throw new ArithmeticException("Sorry, I can't raising zero in negative pow");
                }
                if (Double.isInfinite(Math.pow(first, second))) {
                    throw new ArithmeticException("Sorry, but you are getting INFINITY");
                }
                return Math.pow(first, second);
            default:
                throw new WrongOperatorException("I don't know this operator");
        }
    }
}
