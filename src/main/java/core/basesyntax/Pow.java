package core.basesyntax;

public class Pow implements Action {
    @Override
    public int execute(int arg1, int arg2) {
        return (int) Math.pow(arg1, arg2);
    }
}
