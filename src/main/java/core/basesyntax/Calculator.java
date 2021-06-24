package core.basesyntax;

import interfaces.OperationValidator;
import java.math.BigDecimal;

public class Calculator implements OperationValidator {
    public BigDecimal calculate(double number1, double number2, char operation) {
        BigDecimal result;

        checkOperationValid(operation);

        switch (operation) {
            case '+':
                result = BigDecimal.valueOf(number1 + number2);
                break;
            case '-':
                result = BigDecimal.valueOf(number1 - number2);
                break;
            case '*':
                result = BigDecimal.valueOf(number1 * number2);
                break;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Can't divide by zero");
                }
                if (number1 / number2 == -0.0) {
                    result = BigDecimal.valueOf(0.0);
                    break;
                }
                result = BigDecimal.valueOf(number1 / number2);
                break;
            default:
                if (number1 == 0 && number2 < 0) {
                    throw new ArithmeticException("Zero cannot have negative power!");
                }
                if (number1 < 0 && number2 != 0) {
                    throw new NumberFormatException("Result is NaN!");
                }
                result = BigDecimal.valueOf(Math.pow(number1, number2));
                break;
        }

        return result;
    }

    @Override
    public boolean checkOperationValid(char character) {
        char[] allOperations = {'+', '-', '*', '/', '^'};
        for (char operation : allOperations) {
            if (operation == character) {
                return true;
            }
        }
        throw new IllegalArgumentException("Input operation is incorrect!");
    }
}
