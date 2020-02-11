package core.basesyntax;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calculator {

    private static HashMap<Character, BinaryOperator> calculator = new HashMap();
    private static final BinaryOperator<Integer> addition = Integer::sum;
    private static final BinaryOperator<Integer> subtraction = (x,y) -> x - y;
    private static final BinaryOperator<Integer> multiplication = (x,y) -> x * y;
    private static final BinaryOperator<Integer> division = (x,y) -> x / y;
    private static final BinaryOperator<Integer> power = (x,y) -> Math.toIntExact(Math.round(Math.pow(x, y)));
    static {
        calculator.put('+', addition);
        calculator.put('-', subtraction);
        calculator.put('*', multiplication);
        calculator.put('/', division);
        calculator.put('^', power);
    }
    public static int calculate(Character operation, int first, int second) {
        try{
            return (int) calculator.get(operation).apply(first,second);
        } catch (IllegalArgumentException e) {
            throw new NullPointerException("Incorrect input operation symbol");
        } catch (ArithmeticException e) {
            throw new ArithmeticException(e.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate('+', Integer.MAX_VALUE,3));
    }

}
