package core.basesyntax;

public enum Operation {
    ADDITION("+") {
        public double operation(double first, double second) {
            return first + second;
        }
    },
    SUBTRACTION("-") {
        public double operation(double first, double second) {
            return first - second;
        }
    },
    DIVISION("/") {
        public double operation(double first, double second) {
            if (second == 0) {
                throw new ArithmeticException("Can't divide by zero");
            }
            return first / second;
        }
    },
    MULTIPLICATION("*") {
        public double operation(double first, double second) {
            return first * second;
        }
    },
    POWER("^") {
        public double operation(double first, double second) {
            return Math.pow(first, second);
        }
    };

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperation(String value) {
        for (Operation o : values()) {
            if (o.operation.equals(value)) {
                return o;
            }
        }
        throw new NoSuchOperationException("Please enter the valid operation");
    }

    public abstract double operation(double first, double second);
}
