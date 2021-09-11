package core.basesyntax;

public class LambdaCalculator implements Calculator {
    private Double out;

    @Override
    public double calculate(double first, double second, char operator) {
        switch (operator) {
            case '+':
                if ((first + second == Double.POSITIVE_INFINITY)
                        || (first + second == Double.NEGATIVE_INFINITY)
                        || (first == Double.MAX_VALUE && second > 0)
                        || (second == Double.MAX_VALUE && first > 0)
                        || (first == -Double.MAX_VALUE && second < 0)
                        || (second == -Double.MAX_VALUE && first < 0)) {
                    throw new ExpectedException("You exceeded double range!!!");
                } else {
                    return first + second;
                }
            case '-':
                if ((first + second == Double.POSITIVE_INFINITY)
                        || (first + second == Double.NEGATIVE_INFINITY)
                        || (first == -Double.MAX_VALUE && second > 0)
                        || (second == -Double.MAX_VALUE && first > 0)
                        || (first == Double.MAX_VALUE && second < 0)
                        || (second == Double.MAX_VALUE && first < 0)) {
                    throw new ExpectedException("You exceeded double range!!!");
                } else {
                    return first - second;
                }
            case '/':
                if ((first / second <= Double.MIN_VALUE && first / second > 0.0)
                        || second == 0.00
                        || second == -0.00
                        || second == Double.POSITIVE_INFINITY
                        || first == Double.NEGATIVE_INFINITY
                        || first == Double.POSITIVE_INFINITY
                        || second == Double.NEGATIVE_INFINITY) {
                    throw new ExpectedException("You exceeded double range!!!");
                } else {
                    return first / second;
                }
            case '*':
                if ((first * second >= Double.MAX_VALUE)
                        || first * second == Double.NEGATIVE_INFINITY
                        || first * second == Double.POSITIVE_INFINITY
                        || (first * second <= -Double.MAX_VALUE)) {
                    throw new ExpectedException("You exceeded double range!!!");
                } else {
                    return first * second;
                }
            case '^':
                out = Math.pow(first, second);
                if (Math.pow(first, second) >= Double.MAX_VALUE
                        || Math.pow(first, second) <= -Double.MAX_VALUE
                        || out.isNaN()
                ) {
                    throw new ExpectedException("You exceeded double range!!!");
                } else {
                    return Math.pow(first, second);
                }
            default:
                throw new ExpectedException("Wrong operator for my calculator");
        }
    }
}
