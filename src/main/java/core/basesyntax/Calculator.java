package core.basesyntax;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double left, double right, char operator) {
        return Arrays.stream(EnumOperation.values())
                .filter(op -> op.getOperatorSymbol() == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("Operation '%s' is not supported", operator)))
                .getResult(left, right);
    }

    private enum EnumOperation {
        ADD('+', (l, r) -> l + r),
        SUB('-', (l, r) -> l - r),
        MUL('*', (l, r) -> l * r),
        DIV('/', (l, r) -> l / r),
        POW('^', Math::pow);

        private final char operatorSymbol;
        private final DoubleBinaryOperator binaryOperator;

        EnumOperation(char operatorSymbol, DoubleBinaryOperator binaryOperator) {
            this.operatorSymbol = operatorSymbol;
            this.binaryOperator = binaryOperator;
        }

        public char getOperatorSymbol() {
            return operatorSymbol;
        }

        public double getResult(double left, double right) {
            return binaryOperator.applyAsDouble(left, right);
        }
    }
}
