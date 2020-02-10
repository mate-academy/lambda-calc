import core.basesyntax.Calculate;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculate.getResult(10,20,'+'));
        System.out.println(Calculate.getResult(-15,7,'-'));
        System.out.println(Calculate.getResult(10,20,'*'));
        System.out.println(Calculate.getResult(-10,0,'/'));
        System.out.println(Calculate.getResult(4,2,'^'));
    }
}
