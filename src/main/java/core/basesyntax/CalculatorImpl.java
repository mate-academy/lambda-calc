package core.basesyntax;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(double firstNumber, double secondNumber,
                            ArithmeticOperation arithmeticOperation) {
        switch (arithmeticOperation) {
            case ADD :
                if (firstNumber == Double.MAX_VALUE || secondNumber == Double.MAX_VALUE) {
                    throw new ArithmeticException("Too big data");
                }
                return firstNumber + secondNumber;
            case SUB :
                if (firstNumber == Double.MIN_VALUE && secondNumber != firstNumber
                        && secondNumber > 0) {
                    throw new ArithmeticException("Too small data");
                }
                return firstNumber - secondNumber;
            case MUL :
                if (firstNumber == Double.MAX_VALUE || secondNumber == Double.MAX_VALUE
                        || (long) firstNumber * secondNumber > Double.MAX_VALUE) {
                    throw new ArithmeticException("Too big data");
                }
                return firstNumber * secondNumber;
            case DIV :
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero detected");
                }
                return firstNumber / secondNumber;
            case POW :
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new ArithmeticException("Wrong data");
        }
    }
}
