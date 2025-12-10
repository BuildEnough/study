package casting;

public class Casting2 {
    public static void main(String[] args) {
        double doubleValue = 10.5;
        int intValue = 0;

        // intValue = doubleValue; // 컴파일 오류
        intValue = (int) doubleValue;
        System.out.println("intValue = " + intValue);
        System.out.println((int) 10.5);
        System.out.println("doubleValue = " + doubleValue);

    }
}
