package core.basesyntax;

public class Addition implements Action {
    @Override
    public int execute(int arg1, int arg2) {
        return arg1 + arg2;
    }
}
