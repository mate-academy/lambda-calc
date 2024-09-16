package core.basesyntax;

public class Calculator {

    public double calculate(double number1, double number2, char operation) {

        switch (operation) {
            case '+' : {
                return number1 + number2;
            }
            case '-' : {
                return number1 - number2;
            }
            case '*' : {
                return number1 * number2;
            }
            case '/' : {
                if (number2 == 0) {
                    throw new ArithmeticException("We can not divide any number by 0");
                } else {
                    return number1 / number2;
                }
            }
            case '^' : {
                if (number1 < 0 && number2 % 1 != 0) {
                    throw new ArithmeticException("We can not raise a negative number to "
                            + "a fractional power");
                }
                return Math.pow(number1, number2); }
            default: throw new UnsupportedOperationException("You use illegal operation");
        }
    }
}
