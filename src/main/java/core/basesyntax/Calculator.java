package core.basesyntax;

class Calculator implements Calculate {

    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("Cannot be divisible by zero!");
                }
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new RuntimeException("There is no such operation " + operation);
        }
    }
}
