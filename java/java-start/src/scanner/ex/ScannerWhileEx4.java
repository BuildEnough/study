package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPrice = 0;
        while (true) {
            System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");
            int input = scanner.nextInt();

            if (input == 1) {
                scanner.nextLine();
                System.out.print("상품명을 입력하세요: ");
                String itemName = scanner.nextLine();
                System.out.print("상품의 가격을 입력하세요: ");
                int itemPrice = scanner.nextInt();
                System.out.print("구매 수량을 입력하세요: ");
                int itemQuantity = scanner.nextInt();

                totalPrice += itemPrice * itemQuantity;
                System.out.println("상품명: " + itemName +" 가격: " + itemPrice + " 수량: "  + itemQuantity + " 합계: " + itemPrice * itemQuantity);
            }

            else if (input == 2) {
                System.out.println("총 비용: " + totalPrice);
                totalPrice = 0;
            }

            else if (input == 3) {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            else {
                System.out.println("올바른 옵션을 선택해주세요");
            }
        }

    }
}
