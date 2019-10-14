package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static Long firstOperand = null;
    private static Long secondOperand = null;
    private static Character operation = null;
    private static Long expected = null;
    private static Long actual = null;


    @Test
    public void sum() {
        operation = Character.valueOf('+');
        for(int i = -10; i < 10; i+=2){
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = Long.sum(firstOperand, secondOperand);
            Assert.assertEquals("Incorrect result", actual, expected);
        }
    }

    @Test
    public void commutativeSum(){
        operation = Character.valueOf('+');
        for(int i = -10; i < 10; i+=2){
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = Calculator.apply(secondOperand, operation, firstOperand);
            Assert.assertEquals("Sum should have commutative property ", actual, expected);
        }
    }


    @Test
    public void commutativeMultiplication() {
        operation = Character.valueOf('*');
        for (int i = 0; i < 10; i++) {
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = Calculator.apply(secondOperand, operation, firstOperand);
            Assert.assertEquals("Multiplication should have commutative property ", actual, expected);
        }
    }

    @Test
    public void subtraction() {
        operation = Character.valueOf('-');
        for(int i = -10; i < 10; i+=2){
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = firstOperand - secondOperand;
            Assert.assertEquals("Incorrect result", actual, expected);
        }
    }

    @Test
    public void multiplication() {
        operation = Character.valueOf('*');
        for(int i = -10; i < 10; i+=2){
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = firstOperand * secondOperand;
            Assert.assertEquals("Incorrect result", actual, expected);
        }
    }

    @Test
    public void division() {
        operation = Character.valueOf('/');
        for(int i = 100; i < 1000; i+=100){
            firstOperand = Long.valueOf(i * i);
            secondOperand = Long.valueOf(i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = firstOperand / secondOperand;
            Assert.assertEquals("Incorrect result", actual, expected);
        }
    }

    @Test
    public void exponent() {
        operation = Character.valueOf('^');
        for(int i = -10; i < 10; i+=2){
            firstOperand = Long.valueOf(i);
            secondOperand = Long.valueOf(10 - i);
            actual = Calculator.apply(firstOperand, operation, secondOperand);
            expected = (long)Math.pow(firstOperand, secondOperand);
            Assert.assertEquals("Incorrect result", actual, expected);
        }
    }

    @Test(expected = ArithmeticException.class)
    public void illegalArgument() {
        Calculator.apply(1L, '/', 0L);
    }

    @Test(expected = NullPointerException.class)
    public void nullArgumentTest() {
        firstOperand = null;
        Calculator.apply(firstOperand, '-', secondOperand);
    }
}