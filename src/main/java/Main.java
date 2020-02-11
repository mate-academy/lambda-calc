import core.basesyntax.Calculate;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.getResult(10,20,'+'));
        System.out.println(calculate.getResult(-15,7,'-'));
        System.out.println(calculate.getResult(10,20,'*'));
        System.out.println(calculate.getResult(-10,0,'/'));
        System.out.println(calculate.getResult(4,2,'^'));
    }
}
