package core.basesyntax;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double first, double second, char action) {
        switch (action) {
            case '+':
                return first + second;
        }
        return first + second;
    }
}
