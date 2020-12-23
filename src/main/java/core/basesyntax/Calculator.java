package core.basesyntax;

public class Calculator {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MUL = '*';
    private static final char POW = '^';

    public double calculate(int firstNumber, int secondNumber, char arithmeticalSymbol) {
        switch (arithmeticalSymbol) {
            case ADD:
                return Math.addExact(firstNumber, secondNumber);
            case SUB:
                long tempResult = (long) firstNumber - secondNumber;
                if (tempResult > Integer.MAX_VALUE || tempResult < Integer.MIN_VALUE) {
                    throw new ArithmeticException("Too big result");
                }
                return tempResult;
            case MUL:
                return Math.multiplyExact(firstNumber, secondNumber);
            case DIV:
                if (secondNumber == 0) {
                    throw new ArithmeticException("Delete by zero");
                }
                return ((double) firstNumber) / secondNumber;
            case POW:
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new ArithmeticException(
                        String.format("Wrong arithmetic operation. Was %s",
                                arithmeticalSymbol));
        }
    }
}
