package method;

public class MethodReturn2 {
    public static void main(String[] args) {
        checkAge(10);
    }

    public static void checkAge(int age) {
        if (age < 18) {
            System.out.println(age + "살, 미성년자는 출입 불가능");
            return; // return을 있으면 해당 메서드를 빠져 나감, 밑에 println 문 사용 안됨
        }

        System.out.println(age + "살 입장하세요");
    }
}
