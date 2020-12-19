package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator implements Calculable{
    public static int calculate(int value1, int value2, char operand) {
        switch(operand) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '/':
                return value1 / value2;
            case '*':
                return value1 * value2;
            case '^':
                return (int) Math.pow(value1, value2);
            default:
                throw new RuntimeException("ERROR impossible operand detected: " + operand);
        }
    }
}
