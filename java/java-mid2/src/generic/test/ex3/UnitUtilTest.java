package generic.test.ex3;

import generic.test.ex3.unit.Marine;

public class UnitUtilTest {

    public static void main(String[] args) {
        Marine m1 = new Marine("마린1", 40);
        Marine m2 = new Marine("마린1", 50);
        Marine resultMarine = UnitUtil.maxHp(m1, m2);
        System.out.println("resultMarine = " + resultMarine);

        Marine z1 = new Marine("질럿1", 100);
        Marine z2 = new Marine("질럿2", 1500);
        Marine resultZealot = UnitUtil.maxHp(z1, z2);
        System.out.println("resultZealot = " + resultZealot);
    }
}
