package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator implements Calculable{

    @Override
    public int calculate(int operand1, int operand2, char operator) {
        switch(operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '/':
                return operand1 / operand2;
            case '*':
                return operand1 * operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                throw new RuntimeException("ERROR impossible operand detected: " + operator);
        }
    }
}
