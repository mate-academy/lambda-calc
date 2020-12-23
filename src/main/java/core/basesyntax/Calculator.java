package core.basesyntax;

public class Calculator {
    public double calculation(int number1, int number2, char action) {
        double output;
        switch (action) {
            case '+':
                output = number1 + number2;
                break;
            case '-':
                output = number1 - number2;
                break;
            case '*':
                output = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    throw new DivisionByZeroException("You can't use zero as second number");
                }
                if (number1 == 0) {
                    output = 0;
                    break;
                }
                output = (double) number1 / number2;
                break;
            case '^':
                output = Math.pow(number1, number2);
                break;
            default:
                throw new UnexpectedOperatorException(
                        "You are able to use only +,-,/,*,^ operators");
        }
        return output;
    }
}
