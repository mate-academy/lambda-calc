package core.basesyntax;

import java.util.Arrays;

public class Calculator implements SimpleCalculator {
    enum Operations {
        ADD('+') {
            double execute(double a, double b) {
                return a + b;
            }
        },
        SUBTRACT('-') {
            double execute(double a, double b) {
                return a - b;
            }
        },
        MULTIPLY('*') {
            double execute(double a, double b) {
                return a * b;
            }
        },
        DIVIDE('/') {
            double execute(double a, double b) {
                assert b != 0;
                return a / b;
            }
        },
        POWER('^') {
            double execute(double a, double b) {
                return Math.pow(a, b);
            }
        };

        Operations(char operator) {
            this.operator = operator;
        }

        private char operator;

        abstract double execute(double a, double b);

        public static Operations getOperationByOperator(char operator) {
            return Arrays.stream(Operations.values()).filter(operators
                    -> operators.operator == operator).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Operator not found."));
        }
    }

    @Override
    public double calculate(double firstValue, double secondValue, char operator) {
        Operations operation = Operations.getOperationByOperator(operator);
        return operation.execute(firstValue, secondValue);
    }
}
