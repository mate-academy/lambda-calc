package core.basesyntax;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Assertions.assertThat;
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
        return dataSet.getValueX() + " - " + dataSet.getValueY() + " = " + dataSet.getExpectedResult();
    }


}