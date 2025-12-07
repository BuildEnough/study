package operator;

public class Logical1 {
    public static void main(String[] args) {
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);
        System.out.println();

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);
        System.out.println();

        System.out.println(!true);
        System.out.println(!false);
        System.out.println();

        boolean a = true;
        boolean b = false;
        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(!a);
        System.out.println(!b);
    }
}
