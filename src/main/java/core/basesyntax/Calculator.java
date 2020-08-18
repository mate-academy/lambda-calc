package core.basesyntax;

public class Calculator {

    public double calcuate(float firstValue, float secondValue, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = firstValue + secondValue;
                break;
            case '-':
                result = firstValue - secondValue;
                break;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                result = firstValue / secondValue;
                break;
            case '*':
                result = firstValue * secondValue;
                break;
            case '^':
                result = Math.pow(firstValue, secondValue);
                break;
            default:
                throw new RuntimeException("No valid operation!");
        }
        return result;
    }
}



