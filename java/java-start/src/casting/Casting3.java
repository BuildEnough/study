package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647; // int 최고값
        long maxIntOver = 2147483649L; // int 최고값 + 2
        int intValue = 0;

        // 문제 안됨
        intValue = (int) maxIntValue;
        System.out.println("maxIntValue casting = " + intValue);

        // 문제 됨
        intValue = (int) maxIntOver;
        System.out.println("maxIntOver casting = " + intValue);
    }
}
