package core.basesyntax;

public class MyCalculator implements Calculator {

    @Override
    public double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+' :
                return a + b;
        }
        return 0;
    }
}
