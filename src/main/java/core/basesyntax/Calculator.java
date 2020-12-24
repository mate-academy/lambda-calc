package core.basesyntax;

public class Calculator {

    public boolean checkForNull(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new NullPointerException();
        }
        return true;
    }
    
    public double calculate(Double firstNumber, Double secondNumber, char operations) {
        checkForNull(firstNumber, secondNumber);
        switch (operations) {
            case '+' :
                return firstNumber + secondNumber;
            case '-' :
                return firstNumber - secondNumber;
            case '*' :
                return firstNumber * secondNumber;
            case '/' :
                if (secondNumber == 0) {
                    throw new ArithmeticException("Divide to zero");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default :
                return 0;
        }
    }
}
