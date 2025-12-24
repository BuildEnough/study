package lang.test;

public class TestString10 {
    public static void main(String[] args) {
        String fruits = "apple,banana,mango";

        String[] fruit = fruits.split(",");
        for (String result : fruit) {
            System.out.println(result);
        }

        String joinedString = String.join("->", fruit);
        System.out.println("joinedString = " + joinedString);
    }
}
