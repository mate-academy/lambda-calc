package core.basesyntax;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getNum();
        char operation = getOperation();
        int num2 = getNum();

        int result = calc(num1, num2, operation);
        System.out.println("Result: " + result);
    }

    public static int getNum() {
        System.out.println("Enter the number:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Enter the number:");
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

    public static int calc(int num1, int num2, char operation) {
        int result = 0;
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
            case '/':
                result = num1 / num2;
                break;
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

    private static int doRaising(int num1, int num2) {
        if (num2 < 0) {
            throw new IllegalArgumentException("[" + num2 + "] raising is incorrect");
        }
        int result = 1;
        for (int i = 1; i <= num2; i++) {
            result = result * num1;
        }
        return result;
    }
}
