package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
//        integerBox.set("문자100"); // Integer 타입만 허용
        integerBox.set(10);
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);
    }
}
