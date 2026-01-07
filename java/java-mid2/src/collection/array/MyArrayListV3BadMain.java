package collection.array;

public class MyArrayListV3BadMain {

    public static void main(String[] args) {
        MyArrayListV3 numberList = new MyArrayListV3();
        
        numberList.add(1);
        numberList.add(2);
        numberList.add("문자3");
        System.out.println( numberList);

        // Object를 반환하므로 다운 캐스팅 필요
        Integer numb1 = (Integer) numberList.get(0);
        Integer numb2 = (Integer) numberList.get(1);

        // ClassCaseException 발생, 문자를 Integer로 캐스팅
//        Integer numb3 = (Integer) numberList.get(2);


    }
}
