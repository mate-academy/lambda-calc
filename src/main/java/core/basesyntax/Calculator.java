package core.basesyntax;

public class Calculator implements CalculatorInter {

    public double calculate(double number1, double number2, char operation) {
        switch (operation) {
            case '+': {
                return number1 + number2;
            }
            case '-': {
                return number1 - number2;
            }
            case '/': {
                if (number2 == 0) {
                    throw new RuntimeException("Can not division to zero");
                }
                return number1 / number2;
            }
            case '*': {
                if ((number1 * number2) > Double.MAX_VALUE && (number1 * number2) < Double.MIN_VALUE
                            || Double.isInfinite(number1 * number2)) {
                    throw new RuntimeException("Return value is very big");
                }
                return number1 * number2;
            }
            case 'p': {
                return Math.pow(number1, number2);
            }
            default: {
                throw new RuntimeException("illegal operation");
            }
        }
    }
}
