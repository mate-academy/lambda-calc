package core.basesyntax;

public class Util {
    public static <T> T throwException(String msg) {
        throw new RuntimeException(msg);
    }
}
