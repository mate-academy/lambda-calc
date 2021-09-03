package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    double calculate(double number1, double number2, char sign) {
        if (sign == '+') {
            return number1 + number2;
        }
        if (sign == '-') {
            return number1 - number2;
        }
        if (sign == '/') {
            if (number2 == 0) {
                throw new ArithmeticException("/ by zero");
            }
            return number1 / number2;
        }
        if (sign == '*') {
            return number1 * number2;
        }
        if (sign == '^') {
            return Math.pow(number1, number2);
        }
        return 0.0;
    }

}
