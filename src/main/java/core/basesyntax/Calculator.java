package core.basesyntax;

public class Calculator {
    double calculate(double first, char sign, double second) {
        switch (sign) {
            case '+':
                return addition(first, second);
            case '/':
                return division(first, second);
            case '*':
                return multiplying(first, second);
            case '-':
                return subtraction(first, second);
            case '^':
                return toDegree(first, second);
            default:
                throw new IllegalArgumentException("There is no such operation here!");
        }
    }

    private double toDegree(double first, double second) {
        return Math.pow(first, second);
    }

    private double subtraction(double first, double second) {
        return first - second;
    }

    private double multiplying(double first, double second) {
        return first * second;
    }

    private double division(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("You can't divide by zero!");
        }
        return first / second;
    }

    private double addition(double first, double second) {
        return first + second;
    }
}
