package core.basesyntax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorImpl implements Calculator {

    public static final String NUMBERS = "-?\\d+\\.?\\d+|-?\\d+";
    public static final String CHARACTER = "[+/*^]|--";

    @Override
    public double calculate(String expression) {
        checkExpression(expression);
        Matcher matcher = Pattern.compile(NUMBERS).matcher(expression);
        double a = getNum(matcher);
        double b = getNum(matcher);
        char characterOperation = getCharacter(Pattern.compile(CHARACTER).matcher(expression));
        return calculate(a, b, characterOperation);
    }

    @Override
    public double calculate(double a, double b, char operation) {
        if (operation == '*') {
            return multiply(a, b);
        }
        if (operation == '+') {
            return add(a, b);
        }
        if (operation == '-') {
            return subtract(a, b);
        }
        if (operation == '/') {
            return div(a, b);
        }
        if (operation == '^') {
            return pow(a, b);
        }
        throw new IllegalArgumentException("Not defined function");
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divide on zero");
        }
        return a / b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double pow(double a, double power) {
        return Math.pow(a, power);
    }

    private void checkExpression(String expression) {
        if (!expression.matches("-?\\d+\\.?\\d+\\s?[+*^/]\\s*-?\\d+\\.?\\d+|"
                + "-?\\d+\\s?[+*^/]\\s*-?\\d+|"
                + "-?\\d+\\s?--\\s*-?\\d+|"
                + "-?\\d+\\.?\\d+\\s?--\\s*-?\\d+\\.?\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private char getCharacter(Matcher matcher) {
        if (matcher.find()) {
            return matcher.group().charAt(0);
        }
        throw new IllegalArgumentException();
    }

    private double getNum(Matcher matcher) {
        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        }
        throw new IllegalArgumentException();
    }
}
