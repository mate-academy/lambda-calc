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

        char method = scan.next().charAt(0);
        Serializable result = method == '+' ? calculator.addition(num1, num2)
                : method == '-' ? calculator.removal(num1, num2)
                : method == '/' ? calculator.division(num1, num2)
                : method == '*' ? calculator.multiplication(num1, num2)
                : method == '^' ? calculator.pow(num1, num2)
                : false;

        System.out.println(result);
    }
}
