package core.basesyntax;

public class Calculator {

    public double calculate(double value1, double value2, char operation){
        double result = 0.0;
        switch (operation) {
            case '-':
                return value1 - value2;
            case '+':
                return value1 + value2;
            case '*':
                return value1 * value2;
        }
        return result;
    }
}
