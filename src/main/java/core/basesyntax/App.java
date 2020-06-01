package core.basesyntax;

import java.io.Serializable;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println("Please enter 2 operands ");
        Scanner scan = new Scanner(System.in);
        Double num1 = scan.nextDouble();
        Double num2 = scan.nextDouble();
        System.out.println("Please enter the method you would like to use "
                + "(+ , - , * , / , ^ ");
        String method = scan.next();
        char mathSign = method.charAt(0);
        Serializable result = mathSign == '+' ? calculator.addition(num1, num2)
                : mathSign == '-' ? calculator.removal(num1, num2)
                : mathSign == '/' ? calculator.division(num1, num2)
                : mathSign == '*' ? calculator.multiplication(num1, num2)
                : mathSign == '^' ? calculator.pow(num1, num2)
                : false;

        System.out.println(result);
        Double rem = calculator.removal(-6.0, 2.0);
        System.out.println(rem);
    }
}
