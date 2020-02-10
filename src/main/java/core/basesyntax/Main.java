package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.calculate(1, 2, '+'));
        System.out.println(Calculator.calculate(5, 22, '-'));
        System.out.println(Calculator.calculate(11, 3, '*'));
        System.out.println(Calculator.calculate(21, 3, '/'));
        System.out.println(Calculator.calculate(12, 3, '^'));
    }
}
