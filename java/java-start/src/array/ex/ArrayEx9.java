package array.ex;

import java.util.Scanner;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maxProducts = 10;
        String[] productNames = new String[maxProducts];
        int[] productPrices = new int[maxProducts];
        int productCount = 0;

        while (true) {
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요: ");
            String menu = input.nextLine();

            if (menu.equals("1")) {
                if(productCount >= 10){ System.out.println("더 이상 상품을 등록할 수 없습니다"); break;}
                else {
                    System.out.print("상품 이름을 입력하세요: ");
                    productNames[productCount] = input.nextLine();
                    System.out.print("상품 가격을 입력하세요: ");
                    productPrices[productCount] = input.nextInt();
                    productCount++;
                }
            }
            else if (menu.equals("2")) {
                if (productCount == 0) { System.out.println("등록된 상품이 없습니다."); }
                else {
                    for (int i = 0; i < productCount; i++) {
                        System.out.println(productNames[i] + ": " + productPrices[i] + "원");
                    }
                }
            }
            else if (menu.equals("3")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("올바른 메뉴를 선택해주세요");
            }
        }

    }
}
