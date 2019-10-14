package core.basesyntax;

import java.util.HashMap;

public class Calc {
    private char action;
    private HashMap<Character, Double> actions;

    Calc(double a, char action, double b) {
        this.action = action;
        actions = new HashMap<>();
        actions.put('+', Calc.add(a, b));
        actions.put('*', Calc.multiply(a, b));
        actions.put('/', Calc.divide(a, b));
        actions.put('-', Calc.difference(a, b));
        actions.put('^', Calc.power(a, b));
    }

    double calculate() {
        return actions.get(action);
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero!");
        }
        return a / b;
    }

    private static double difference(double a, double b) {
        return a - b;
    }

    private static double power(double a, double b) {
        if (b > 0) {
            double result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
            return result;
        }
        if (b < 0) {
            double result = 1;
            for (int i = 0; i > b; i--) {
                result *= (1 / a);
            }
            return result;
        }
        return 0;
    }
}
