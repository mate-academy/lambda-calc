package core.basesyntax;

public class LambdaCalculator implements Calculator {
    private Double out;

    @Override
    public double calculate(double first, double second, char operator) {
        switch (operator) {
            case '+':
                checkPlusException(first, second);
                return first + second;
            case '-':
                checkMinusException(first, second);
                return first - second;
            case '/':
                checkDivisionException(first, second);
                return first / second;
            case '*':
                checkMultiplicationException(first, second);
                return first * second;
            case '^':
                checkPowerException(first, second);
                return Math.pow(first, second);
            default:
                throw new ArgumentsValidationException("Wrong operator for my calculator");
        }
    }

    private void checkPlusException(double first, double second) {
        if ((first + second == Double.POSITIVE_INFINITY)
                || (first + second == Double.NEGATIVE_INFINITY)
                || (first == Double.MAX_VALUE && second > 0)
                || (second == Double.MAX_VALUE && first > 0)
                || (first == -Double.MAX_VALUE && second < 0)
                || (second == -Double.MAX_VALUE && first < 0)) {
            throw new ArgumentsValidationException("You exceeded double range!!!");
        }
    }

    private void checkMinusException(double first, double second) {
        if ((first + second == Double.POSITIVE_INFINITY)
                || (first + second == Double.NEGATIVE_INFINITY)
                || (first == -Double.MAX_VALUE && second > 0)
                || (second == -Double.MAX_VALUE && first > 0)
                || (first == Double.MAX_VALUE && second < 0)
                || (second == Double.MAX_VALUE && first < 0)) {
            throw new ArgumentsValidationException("You exceeded double range!!!");
        }
    }

    private void checkMultiplicationException(double first, double second) {
        if ((first * second >= Double.MAX_VALUE)
                || first * second == Double.NEGATIVE_INFINITY
                || first * second == Double.POSITIVE_INFINITY
                || (first * second <= -Double.MAX_VALUE)) {
            throw new ArgumentsValidationException("You exceeded double range!!!");
        }
    }

    private void checkDivisionException(double first, double second) {
        if ((first / second <= Double.MIN_VALUE && first / second > 0.0)
                || second == 0.00
                || second == -0.00
                || second == Double.POSITIVE_INFINITY
                || first == Double.NEGATIVE_INFINITY
                || first == Double.POSITIVE_INFINITY
                || second == Double.NEGATIVE_INFINITY) {
            throw new ArgumentsValidationException("You exceeded double range!!!");
        }
    }

    private void checkPowerException(double first, double second) {
        out = Math.pow(first, second);
        if (Math.pow(first, second) >= Double.MAX_VALUE
                || Math.pow(first, second) <= -Double.MAX_VALUE
                || out.isNaN()
        ) {
            throw new ArgumentsValidationException("You exceeded double range!!!");
        }
    }
}
