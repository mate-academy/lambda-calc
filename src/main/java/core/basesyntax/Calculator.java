package core.basesyntax;

public class Calculator {
    double calculation(String sign, Double first, Double second) {
        return sign.equals("+") ? first + second : sign.equals("-") ? first - second
                : sign.equals("*") ? first * second : sign.equals("/") ? first / second
                : sign.equals("^") ? Math.pow(first, second) : null;
    }
}
