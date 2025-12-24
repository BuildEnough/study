package lang.test;

public class TestString11 {
    public static void main(String[] args) {
        String str = "Hello Java";

        StringBuilder sb = new StringBuilder((str));

        String reversed = sb.reverse().toString();
        System.out.println(reversed);
    }
}
