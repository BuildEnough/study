package lang.string.equals;

public class StringEqualsMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("메서드 호출 비교1: " + isSame(str1, str2));

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("메서드 호출 비교2: " + isSame(str4, str4));

    }

    private static boolean isSame(String x, String y) {
//        return x == y; // x, y에 뭐가 들어올지 모름
        return x.equals(y);
    }
}
