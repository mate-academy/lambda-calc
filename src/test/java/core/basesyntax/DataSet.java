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

    private final int valueX;
    private final int valueY;
    private final int expectedResult;

    public DataSet(int valueX, int valueY, int expectedResult) {
        this.valueX = valueX;
        this.valueY = valueY;
        this.expectedResult = expectedResult;
    }

    public int getValueX() {
        return valueX;
    }

    public int getValueY() {
        return valueY;
    }

    public int getExpectedResult() {
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
        Integer valueX = Integer.valueOf(operandSplit[0].trim());
        Integer valueY = Integer.valueOf(operandSplit[1].trim());
        Integer expectedResult = Integer.valueOf(equationSplit[1].trim());
        return new DataSet(valueX, valueY, expectedResult);
    }

}