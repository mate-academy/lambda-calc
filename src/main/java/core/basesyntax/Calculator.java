package core.basesyntax;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num1 = getNum();
        char operation = getOperation();
        double num2 = getNum();

        double result = calc(num1, num2, operation);
        System.out.println("Result: " + result);
    }

    public static double getNum() {
        System.out.println("Enter the number :");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Error. Number can contain [,] and digital");
            scanner.next();
            num = getNum();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Math operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Error. Enter the math.operation:");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/': {
                result = doDivision(num1, num2);
                break;
            }
            case '^': {
                result = doRaising(num1, num2);
                break;
            }
            default:
                throw new IllegalArgumentException(
                        "Unsupported math operation. Enter from [+ - * / ^]");
        }
        return result;
    }

    private static double doDivision(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return num1 / num2;
    }

    private static double doRaising(double num1, double num2) {
        if (num2 < 0) {
            throw new IllegalArgumentException("[" + num2 + "] raising is incorrect");
        }
        double result = 1;
        for (int i = 1; i <= num2; i++) {
            result = result * num1;
        }
        return result;
    }
}
