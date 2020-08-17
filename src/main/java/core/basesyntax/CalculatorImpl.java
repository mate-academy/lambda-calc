package core.basesyntax;

public class CalculatorImpl {
    public Double addition(Double operand1, Double operand2) {
        Calculator calc = (op1, op2) -> operand1 + operand2;
        return calculate(operand1, operand2, calc);
    }

    public Double subtract(Double operand1, Double operand2) {
        Calculator calc = (op1, op2) -> operand1 - operand2;
        return calculate(operand1, operand2, calc);
    }

    public Double division(Double operand1, Double operand2) {
        Calculator calc = (op1, op2) -> operand1 / operand2;
        return calculate(operand1, operand2, calc);
    }

    public Double multiplication(Double operand1, Double operand2) {
        Calculator calc = (op1, op2) -> operand1 * operand2;
        return calculate(operand1, operand2, calc);
    }

    public Double pow(Double operand1, Double operand2) {
        Calculator calc = (op1, op2) -> Math.pow(operand1, operand2);
        return calculate(operand1, operand2, calc);
    }

    private double calculate(Double operand1, Double operand2, Calculator calculator) {
        return calculator.calculate(operand1, operand2);
    }
}
