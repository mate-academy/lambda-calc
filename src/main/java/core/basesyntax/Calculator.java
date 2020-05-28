package core.basesyntax;

public class Calculator {
    public static Integer calculate(int num1, int num2, char sign) {
        if (sign == '-') {
            return num1 - num2;
        } else if (sign == '+') {
            return num1 + num2;
        } else if (sign == '*') {
            return num1 * num2;
        } else if (sign == '/' && num2 != 0) {
            return num1 / num2;
        } else {
            throw new CalculateException("Sorry, something is wrong!");
        }
    }
}
