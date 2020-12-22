package core.basesyntax;

public class Calculator {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "^";

    public double calculate(int fistNumber, int secondNumber, String arithmeticalSymbol) {
        if (arithmeticalSymbol == null) {
            throw new NullPointerException();
        }
        arithmeticalSymbol = arithmeticalSymbol.trim();
        switch (arithmeticalSymbol) {
            case ADD:
                return fistNumber + secondNumber;
            case SUB:
                return fistNumber - secondNumber;
            case MUL:
                return fistNumber * secondNumber;
            case DIV:
                if (secondNumber == 0) {
                    throw new ArithmeticException("Delete to zero");
                }
                return ((double) fistNumber) / secondNumber;
            case POW:
                return Math.pow(fistNumber, secondNumber);
            default:
                throw new ArithmeticException(
                        String.format("Wrong arithmetic operation. Was %s",
                                arithmeticalSymbol));
        }
    }
}
