package core.basesyntax;

public class Calculator implements Calculate {

    @Override
    public double calculate(double numberOne, double numberTwo, char operator) {
        switch (operator) {
            case '+' :
                return numberOne + numberTwo;
            case '-' :
                return numberOne - numberTwo;
            case '*' :
                return numberOne * numberTwo;
            case '^' :
                return Math.pow(numberOne, numberTwo);
            case '/' :
                if (numberTwo == 0) {
                    throw new ArithmeticException("We can't divide by 0");
                }
                return numberOne / numberTwo;
            default:
                throw new RuntimeException("Incorrectly entered operator");

        }
    }
}
