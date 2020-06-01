package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println(new Calculator().calculate(1, 2, '^'));
    }

    public int calculate(int a, int b, char operation) {
        return (operation == '+') ? a + b :
                (operation == '-') ? a - b :
                        (operation == '*') ? a * b :
                                (operation == '/') ? a / b :
                                        (operation == '^') ? (int) Math.pow(a, b) :
                                                0;
    }
}
