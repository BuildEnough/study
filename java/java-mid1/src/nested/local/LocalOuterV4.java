package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {

    private int outInstanceVar = 3;

    public Printer process(int parameVar) {
        int localVar = 1; // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거됨

        class LocalPrinter implements Printer {
            int value = 0;

            @Override
            public void print() {
                // 인스턴스는 지역 변수보다 더 오래 살아 남는다
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar); // 지역 변수
                System.out.println("parameVar = " + parameVar); // 지역 변수
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        // 만약 localVar의 값을 변경한다면?, 다시 캡쳐를 해야하나??
        // localVar = 10;
        // parameVar = 20;
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        Printer printer = localOuter.process(2);
        printer.print();

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }

}
