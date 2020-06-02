package core.basesyntax;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;


public class DataSet {

    private final double valueX;
    private final double valueY;
    private final double expectedResult;

    public DataSet(Double valueX, Double valueY, Double expectedResult) {
        this.valueX = valueX;
        this.valueY = valueY;
        this.expectedResult = expectedResult;
    }

    public double getValueX() {
        return valueX;
    }

    public double getValueY() {
        return valueY;
    }

    public double getExpectedResult() {
        return expectedResult;
    }

    public static Stream<DataSet> parseRuleFile(String filePath) {
        try {
            URI resource = DataSet.class.getClassLoader().getResource(filePath).toURI();
            return Files.lines(Paths.get(resource)).map(DataSet::parseRule);
        } catch (IOException | URISyntaxException e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    private static DataSet parseRule(String rule) {
        String[] equationSplit = StringUtils.split(rule, '|');
        String[] operandSplit = StringUtils.split(equationSplit[0], ',');
        Double valueX = Double.valueOf(operandSplit[0].trim());
        Double valueY = Double.valueOf(operandSplit[1].trim());
        Double expectedResult = Double.valueOf(equationSplit[1].trim());
        return new DataSet(valueX, valueY, expectedResult);
    }

}