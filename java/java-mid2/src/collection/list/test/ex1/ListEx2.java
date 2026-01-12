package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while(true) {
            int n = input.nextInt();
            if (n == 0) {
                break;
            }
            list.add(n);
        }

        System.out.println("출력");
        int count = 1;
        for (Integer integer : list) {
            System.out.print(integer);
            if (list.size() == count) {
                break;
            }
            System.out.print(", ");
            count++;
        }


    }
}
