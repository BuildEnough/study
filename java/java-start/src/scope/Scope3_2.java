package scope;

public class Scope3_2 {
    public static void main(String[] args) {
        int m = 10;

        if (m > 0) {
            int temp = m*2; // main() 코드 블록 대신 if문 안에 temp를 사용하는게 효율적
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
