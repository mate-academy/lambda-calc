package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.calculation(10, 20, '+'));
        System.out.println(cal.calculation(10, 20, '-'));
        System.out.println(cal.calculation(10, 20, '*'));
        System.out.println(cal.calculation(10, 5, '/'));
        System.out.println(cal.calculation(10, 2, '^'));
        System.out.println(cal.calculation(10, 2, '!'));
    }
}
