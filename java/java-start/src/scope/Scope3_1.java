package scope;

public class Scope3_1 {
    public static void main(String[] args) {
        int m = 10;
        int temp = 0; // if문 안에만 temp 변수가 살아있어도 됨

        if (m > 0) {
            temp = m*2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
