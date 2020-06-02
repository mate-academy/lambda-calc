package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public int calculate(int a, int b, char operation) {
        if (operation != '+' && (operation != '-') && (operation != '*')
                && (operation != '/') && (operation != '^')) {
            throw new IllegalArgumentException();
        }
        return (operation == '+') ? a + b :
                (operation == '-') ? a - b :
                        (operation == '*') ? a * b :
                                (operation == '/') ? a / b :
                                        (int) Math.pow(a, b);
    }
}
