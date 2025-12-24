package lang.test;

public class TestString9 {
    public static void main(String[] args) {
        String email = "hello@example.com";
        String ID = email.split("@")[0];
        String Domain = email.split("@")[1];

        System.out.println("ID = " + ID);
        System.out.println("Domain = " + Domain);
    }
}
