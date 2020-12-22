package core.basesyntax;

import core.basesyntax.exception.BigValueException;

public class Calculator {
    public static int add(int a, int b) {
        if (a == Integer.MAX_VALUE && b > 0 || b == Integer.MAX_VALUE && a > 0) {
            throw new BigValueException("Big value");
        }
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static double divide(int a, int b) {
        return a / b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int raiseToPower(int a, int power) {
        for (int i = 1; i <= power; i++) {
            a *= a;
        }
        return a;
    }

}
