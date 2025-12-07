package operator;

public class OperatorAdd2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        
        b = ++a; // a의 값을 먼저 증가 -> b에 대입
        System.out.println("b = " + b);
        System.out.println("a = " + a);

        a = 1;
        b = 0;
        b = a++; // a의 현재 값을 b에 대입 -> a의 값을 증가
        System.out.println("b = " + b);
        System.out.println("a = " + a);
    }
}
