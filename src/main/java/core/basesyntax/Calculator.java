package core.basesyntax;

public class Calculator {
    public double calculation(int number1, int number2, char action) {
        switch (action) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (number2 == 0) {
                    throw new DivisionByZeroException("You can't use zero as second number");
                }
                return (double) number1 / number2;
            case '^':
                return Math.pow(number1, number2);
            default:
                throw new UnexpectedOperatorException(
                        "You are able to use only +,-,/,*,^ operators");
        }
    }
}
