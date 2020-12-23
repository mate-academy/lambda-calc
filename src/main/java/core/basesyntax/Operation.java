package core.basesyntax;

public enum Operation {
    ADDITION('+') {
        public double operation(double first, double second) {
            return first + second;
        }
    },
    SUBTRACTION('-') {
        public double operation(double first, double second) {
            return first - second;
        }
    },
    DIVISION('/') {
        public double operation(double first, double second) {
            if (second == 0) {
                throw new ArithmeticException("Can't divide by zero");
            }
            return first / second;
        }
    },
    MULTIPLICATION('*') {
        public double operation(double first, double second) {
            return first * second;
        }
    },
    POWER('^') {
        public double operation(double first, double second) {
            return Math.pow(first, second);
        }
    };

    private char operation;

    Operation(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return operation;
    }

    public abstract double operation(double first, double second);
}
