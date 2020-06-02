package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("---------Using Enum---------");
        List<String> enumResults = List.of(
                "3 + 2 = " + calculator.calculate(3, 2, '+'),
                "3 - 2 = " + calculator.calculate(3, 2, '-'),
                "3 * 2 = " + calculator.calculate(3, 2, '*'),
                "3 / 2 = " + calculator.calculate(3, 0, '/'),
                "3 ^ 2 = " + calculator.calculate(3, 2, '^'));

        enumResults.forEach(System.out::println);
    }
}
