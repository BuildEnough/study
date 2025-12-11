package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요: ");
        int num = input.nextInt();

        int[] arrays = new int[num];

        System.out.println(num + "개의 정수를 입력하세요: ");
        for(int i=0; i< arrays.length; i++) {
            arrays[i] = input.nextInt();
        }

        int total = 0;
        for (int i=0; i<arrays.length; i++){
            total += arrays[i];
        }

        double average = total / arrays.length;

        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + average);

    }
}
