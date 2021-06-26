package core.basesyntax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorImpl implements Calculator {
    public static final String NUMBERS_REGEX = "-?\\d+\\.?\\d*";
    public static final String CHARACTER_REGEX = "[+/*^-]";

    @Override
    public double calculate(String expression) {
        String expressionCopy = expression;
        checkExpression(expressionCopy);
        double a = getNum(expressionCopy);
        expressionCopy = getExpression(expressionCopy, String.valueOf(a));
        double b = getNum(expressionCopy);
        expressionCopy = getExpression(expressionCopy, String.valueOf(b));
        char characterOperation = getCharacter(expressionCopy);
        return calculate(a, b, characterOperation);
    }

    @Override
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '*': {
                return multiply(a, b);
            }
            case '+': {
                return add(a, b);
            }
            case '-': {
                return subtract(a, b);
            }
            case '/': {
                return divide(a, b);
            }
            case '^': {
                return power(a, b);
            }
            default:
                throw new IllegalArgumentException("Not defined function");
        }
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
    public double divide(double a, double b) {
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
    public double power(double a, double power) {
        return Math.pow(a, power);
    }

    /**
     * "-?(\d*\.?\d*)\s*[+*^/-]\s*-?(\d*\.?\d*)" is concatenation of three patterns :
     * 1.NUMBER_REGEX "-?(\\d+\\.?\\d*)" matches positive or negative numbers of int or
     * double(float) type.
     * 2.CHARACTER_REGEX "\\s*[+*^/-]\\s*" matches characters of operations
     * addition '+', subtractive '-', power '^', division '/' or multiplication '*' with or without
     * whitespaces
     * 3.NUMBER_REGEX
     *
     * @param expression input string of math expression
     */
    private void checkExpression(String expression) {
        if (expression.matches(
                "-?(\\d*\\.?\\d*)\\s*[+*^/-]\\s*-?(\\d*\\.?\\d*)")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    /**
     * method seeks in expression necessary character of operation with Pattern CHARACTER_REGEX
     * @param expression input string of math expression
     * @return char of operation
     * @throws IllegalArgumentException if matcher does not find
     */
    private char getCharacter(String expression) {
        Matcher matcher = Pattern.compile(CHARACTER_REGEX).matcher(expression);
        if (matcher.find()) {
            return matcher.group().charAt(0);
        }
        throw new IllegalArgumentException();
    }

    /**
     * method seeks in expression double or int number with Pattern NUMBERS_REGEX
     *
     * @param expression input string of math expression
     * @return double number
     * @throws IllegalArgumentException if matcher does not find
     */
    private double getNum(String expression) {
        Matcher matcher = Pattern.compile(NUMBERS_REGEX).matcher(expression);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(0));
        }
        throw new IllegalArgumentException();
    }

    /**
     * remove string "a" from expressionCopy
     * @param expressionCopy input string of math expression
     * @param a target number
     * @return new string without a
     */
    private String getExpression(String expressionCopy, String a) {
        String fractionalPart = a.substring(a.indexOf(".") + 1);
        if (fractionalPart.length() > 1) {
            return expressionCopy.replaceFirst(a, "");
        }
        return expressionCopy.replaceFirst(a.substring(0, a.indexOf(".")), "");
    }
}
