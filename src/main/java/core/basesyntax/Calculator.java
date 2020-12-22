package core.basesyntax;

public class Calculator {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "^";

    public double calculate(int firstNumber, int secondNumber, String arithmeticalSymbol) {
        if (arithmeticalSymbol == null) {
            throw new NullPointerException();
        }
        arithmeticalSymbol = arithmeticalSymbol.trim();
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
