package core.basesyntax;

public class Calculator {
    private final String ADD = "+";
    private final String SUB = "-";
    private final String DIV = "/";
    private final String MUL = "*";
    private final String POW = "^";

    public double calculate(int fistNumber, int secondNumber, String arithmeticalSymbol) {
        if (arithmeticalSymbol == null) {
            throw new NullPointerException();
        }
        arithmeticalSymbol = arithmeticalSymbol.trim();
        checkSymbol(arithmeticalSymbol);
        double result = 0;
        switch (arithmeticalSymbol) {
            case ADD:
                result = fistNumber + secondNumber;
                break;
            case SUB:
                result = fistNumber - secondNumber;
                break;
            case MUL:
                result = fistNumber * secondNumber;
                break;
            case DIV:
                if (secondNumber == 0) {
                    throw new ArithmeticException("Delete to zero");
                }
                result = fistNumber / secondNumber;
                break;
            case POW:
                result = Math.pow(fistNumber, secondNumber);
                break;
        }
        return result;
    }

    private void checkSymbol(String symbol) {
        if (symbol.length() != 1 || symbol.matches("[*/+-^]")) {
            throw new RuntimeException("Write exception");
        }
    }

}
