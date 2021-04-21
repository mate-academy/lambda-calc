package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    private static final double FIRST_POSITIVE_OPERAND = 0.125;
    private static final double SECOND_POSITIVE_OPERAND = 7.1;
    private static final double FIRST_NEGATIVE_OPERAND = -2.0;
    private static final double SECOND_NEGATIVE_OPERAND = -12.52;
    private static final String ERROR_MESSAGE = "Expected and actual results not equal";
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private double actualResult;


    @Test
    public void additionWithTwoPositiveOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(FIRST_POSITIVE_OPERAND + SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithTwoNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(FIRST_NEGATIVE_OPERAND + SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithPositiveAndNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(FIRST_POSITIVE_OPERAND + SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithZero_Ok(){
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, 0, ADD);
        assertEquals(FIRST_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, 0, ADD);
        assertEquals(FIRST_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, ADD);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(Double.MAX_VALUE + SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(Double.MAX_VALUE + SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MAX_VALUE, ADD);
        assertEquals(FIRST_POSITIVE_OPERAND + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MAX_VALUE, ADD);
        assertEquals(FIRST_NEGATIVE_OPERAND + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithMinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(Double.MIN_VALUE + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(Double.MIN_VALUE + SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(Double.MIN_VALUE + SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MIN_VALUE, ADD);
        assertEquals(FIRST_POSITIVE_OPERAND + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MIN_VALUE, ADD);
        assertEquals(FIRST_NEGATIVE_OPERAND + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void additionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.MIN_VALUE + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionWithTwoPositiveOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, SUBTRACT);
        assertEquals(FIRST_POSITIVE_OPERAND - SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionitionWithTwoNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(FIRST_NEGATIVE_OPERAND - SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionitionWithPositiveAndNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(FIRST_POSITIVE_OPERAND - SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionitionWithZero_Ok(){
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(-SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, 0, SUBTRACT);
        assertEquals(FIRST_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, 0, SUBTRACT);
        assertEquals(FIRST_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(-SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionWithMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_OPERAND, SUBTRACT);
        assertEquals(Double.MAX_VALUE - SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(Double.MAX_VALUE - SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MAX_VALUE, SUBTRACT);
        assertEquals(FIRST_POSITIVE_OPERAND - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MAX_VALUE, SUBTRACT);
        assertEquals(FIRST_NEGATIVE_OPERAND - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionWithMinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE_OPERAND, SUBTRACT);
        assertEquals(Double.MIN_VALUE - SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEGATIVE_OPERAND, SUBTRACT);
        assertEquals(Double.MIN_VALUE - SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MIN_VALUE, SUBTRACT);
        assertEquals(FIRST_POSITIVE_OPERAND - Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MIN_VALUE, SUBTRACT);
        assertEquals(FIRST_NEGATIVE_OPERAND - Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtractionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.MIN_VALUE - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACT);
        assertEquals(Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithTwoPositiveOperands_Ok() {
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, MULTIPLY);
        assertEquals(FIRST_POSITIVE_OPERAND * SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithTwoNegativeOperands_Ok() {
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(FIRST_NEGATIVE_OPERAND * SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(FIRST_POSITIVE_OPERAND * SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithZero_Ok() {
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, 0, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_POSITIVE_OPERAND, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, 0, MULTIPLY);
        assertEquals(FIRST_NEGATIVE_OPERAND * 0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(0 * SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_OPERAND, MULTIPLY);
        assertEquals(Double.MAX_VALUE * SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(Double.MAX_VALUE * SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MAX_VALUE, MULTIPLY);
        assertEquals(FIRST_POSITIVE_OPERAND * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MAX_VALUE, MULTIPLY);
        assertEquals( FIRST_NEGATIVE_OPERAND * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithMinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE_OPERAND, MULTIPLY);
        assertEquals(Double.MIN_VALUE * SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(Double.MIN_VALUE * SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MIN_VALUE, MULTIPLY);
        assertEquals(FIRST_POSITIVE_OPERAND * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MIN_VALUE, MULTIPLY);
        assertEquals(FIRST_NEGATIVE_OPERAND * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplicationWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.MIN_VALUE * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithTwoPositiveOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, DIVIDE);
        assertEquals(FIRST_POSITIVE_OPERAND / SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithTwoNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, DIVIDE);
        assertEquals(FIRST_NEGATIVE_OPERAND / SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithPositiveAndNegativeOperands_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, DIVIDE);
        assertEquals(FIRST_POSITIVE_OPERAND / SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithZero_Ok(){
        actualResult = calculator.calculate(0, SECOND_POSITIVE_OPERAND, DIVIDE);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEGATIVE_OPERAND, DIVIDE);
        assertEquals(0 / SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_POSITIVE_OPERAND, 0, DIVIDE));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_NEGATIVE_OPERAND, 0, DIVIDE));
        assertThrows(ArithmeticException.class,
                () ->  calculator.calculate(0, 0, DIVIDE));
    }

    @Test
    public void divisionWithMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(1, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_OPERAND, DIVIDE);
        assertEquals(Double.MAX_VALUE / SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE_OPERAND, DIVIDE);
        assertEquals(Double.MAX_VALUE / SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MAX_VALUE, DIVIDE);
        assertEquals(FIRST_POSITIVE_OPERAND / Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MAX_VALUE, DIVIDE);
        assertEquals(FIRST_NEGATIVE_OPERAND / Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithMinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(1, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE_OPERAND, DIVIDE);
        assertEquals(Double.MIN_VALUE / SECOND_POSITIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEGATIVE_OPERAND, DIVIDE);
        assertEquals(Double.MIN_VALUE / SECOND_NEGATIVE_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, Double.MIN_VALUE, DIVIDE);
        assertEquals(FIRST_POSITIVE_OPERAND / Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, Double.MIN_VALUE, DIVIDE);
        assertEquals(FIRST_NEGATIVE_OPERAND / Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void divisionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithPositiveOperandsToPositivePow_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithNegativeOperandsToPositivePow_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_NEGATIVE_OPERAND, SECOND_POSITIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithPositiveOperandsToNegativePow_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithNegativeOperandsToNegativePow_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithPositiveOperandsToZeroPow_Ok(){
        actualResult = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_POSITIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_NEGATIVE_OPERAND, SECOND_POSITIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raisingWithNegativeOperandsToZeroPow_Ok(){
        actualResult = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADD);
        assertEquals(Math.pow(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND), actualResult, ERROR_MESSAGE);
    }


//    raising positive/negative value to zero power;
//    raising zero to power;
//    illegal operation;

}
