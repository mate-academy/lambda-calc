package core.basesyntax;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class CalculatorTests {
    public static final char SUM = '+';
    public static final char SUB = '-';
    public static final char MUL = '*';
    public static final char DIV = '/';
    public static final char POW = '^';

    Calculator cut = new Calculator();

    @TestFactory
    Stream<DynamicTest> addition() {
        return DataSet.parseRuleFile("addition-rules.txt")
                .map(dataSet -> dynamicTest(getAdditionDisplayName(dataSet), () -> {
                    double result = cut.calculation(dataSet.getValueX(), dataSet.getValueY(), SUM);
                    assertThat(result).isEqualTo(dataSet.getExpectedResult());
                }));
    }

    String getAdditionDisplayName(DataSet dataSet) {
        return dataSet.getValueX() + " + " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }

    @TestFactory
    Stream<DynamicTest> subtraction() {
        return DataSet.parseRuleFile("substraction-rules.txt")
                .map(dataSet -> dynamicTest(getSubtractionDisplayName(dataSet), () -> {
                    double result = cut.calculation(dataSet.getValueX(), dataSet.getValueY(), SUB);
                    assertThat(result).isEqualTo(dataSet.getExpectedResult());
                }));
    }

    String getSubtractionDisplayName(DataSet dataSet) {
        return dataSet.getValueX() + " - " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }

    @TestFactory
    Stream<DynamicTest> multiply() {
        return DataSet.parseRuleFile("multiplying-rules.txt")
                .map(dataSet -> dynamicTest(getMultiplyDisplayName(dataSet), () -> {
                    double result = cut.calculation(dataSet.getValueX(), dataSet.getValueY(), MUL);
                    assertThat(result).isEqualTo(dataSet.getExpectedResult());
                }));
    }

    String getMultiplyDisplayName(DataSet dataSet) {
        return dataSet.getValueX() + " * " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }

    @TestFactory
    Stream<DynamicTest> divide() {
        return DataSet.parseRuleFile("divide-rules.txt")
                .map(dataSet -> dynamicTest(getDivideDisplayName(dataSet), () -> {
                    double result = cut.calculation(dataSet.getValueX(), dataSet.getValueY(), DIV);
                    assertThat(result).isEqualTo(dataSet.getExpectedResult());
                }));
    }

    String getDivideDisplayName(DataSet dataSet) {
        return dataSet.getValueX() + " / " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }

    @Test
    public void checkDivideByZero() {
        double result = cut.calculation(1.0, 0.0, '/');
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void checkDivideZeroByZero() {
        double result = cut.calculation(0.0, 0.0, '/');
        assertEquals(Double.NaN, result);
    }

    @TestFactory
    Stream<DynamicTest> powering() {
        return DataSet.parseRuleFile("power-rules.txt")
                .map(dataSet -> dynamicTest(getPowerDisplayName(dataSet), () -> {
                    double result = cut.calculation(dataSet.getValueX(), dataSet.getValueY(), POW);
                    assertThat(result).isEqualTo(dataSet.getExpectedResult());
                }));
    }

    String getPowerDisplayName(DataSet dataSet) {
        return dataSet.getValueX() + " ^ " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }
}