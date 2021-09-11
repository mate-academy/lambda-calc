package core.basesyntax;

public class Calculator {
  public double calculate(double firstValue, double secondValue, char operation) {
      if (firstValue == Double.MAX_VALUE && secondValue > 0
              || secondValue == Double.MAX_VALUE && firstValue > 0) {
          throw new ArithmeticException("doubleMaxValue Error");
      }
      double result;
      switch (operation) {
          case '+':
              result = firstValue + secondValue;
              break;

          case '-':
              result = firstValue - secondValue;
              break;

          default:
              result = 0;
      }
      return result;
  }
}
