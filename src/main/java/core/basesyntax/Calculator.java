package core.basesyntax;

public class Calculator {
    public static Integer calculate(int num1, int num2, char sign) {
        switch (sign) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                }
            default:
                throw new CalculateException("Sorry, something is wrong");
        }
    }
}
