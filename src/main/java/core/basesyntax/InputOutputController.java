package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

public class InputOutputController {
    private static final Logger logger = Logger.getLogger(InputOutputController.class);
    private static final int FIRST_INDEX_STRING = 0;
    private static final int SIZE_LIST = 5;
    private static final int SIZE_MAP = 1;
    private static List<String> list = new ArrayList<>(SIZE_LIST);
    private static Map<String, String> map = new HashMap<>(SIZE_MAP);

    static {
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("^");

        map.put("q", "0");
    }

    public static Optional<Integer> inputOperand() {
        try {
            System.out.println("Input operand:");
            Integer result = Integer.parseInt(inputString().orElseThrow());
            return Optional.ofNullable(result);
        } catch (Exception e) {
            logger.error("Incorrect operand ", e);
            System.out.println("Incorrect operand!");
            return Optional.empty();
        }
    }

    public static Optional<Character> inputOperation() {
        try {
            System.out.println("Input operation:");
            String string = inputString().orElseThrow();
            String stringOfList = list.stream()
                    .filter(s -> s.equalsIgnoreCase(string))
                    .findFirst()
                    .orElseThrow();
            return Optional.ofNullable(stringOfList.charAt(FIRST_INDEX_STRING));
        } catch (Exception e) {
            logger.error("Incorrect operation ", e);
            System.out.println("Incorrect opeation!");
            return Optional.empty();
        }
    }

    private static Optional<String> inputString() {
        try {
            System.out.println("For exit input q");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = bufferedReader.readLine();
            Optional<String> optional = Optional.ofNullable(map.get(string));
            optional.ifPresent(n -> System.exit(0));
            return Optional.ofNullable(string);
        } catch (IOException e) {
            logger.error("Excetpiton input-output ", e);
            System.out.println("Excetpiton input-output!");
            return Optional.empty();
        }
    }
}
