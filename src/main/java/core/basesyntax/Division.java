package core.basesyntax;

public class Division implements Action {
    @Override
    public int execute(int arg1, int arg2) {
        if (arg2 == 0) {
            throw new IllegalArgumentException("Dividend cannot be 0");
        }
        return arg1 / arg2;
    }
}
