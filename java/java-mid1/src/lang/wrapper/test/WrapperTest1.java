package lang.wrapper.test;

public class WrapperTest1 {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "20";

        int strInt1 = Integer.parseInt(str1);
        int strInt2 = Integer.parseInt(str2);

        int result = strInt1 + strInt2;

        System.out.println("두 수의 합: " + result);
    }
}
