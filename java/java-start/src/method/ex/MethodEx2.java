package method.ex;

public class MethodEx2 {
    public static void main(String[] args) {
        String msg = "Hello World!";

        message(msg, 3);
        message(msg, 5);
    }

    public static void message(String msg, int j) {
        for (int i=0; i<j; i++) {
            System.out.println(msg);
        }
        System.out.println();
    }

}
