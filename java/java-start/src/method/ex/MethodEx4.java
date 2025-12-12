package method.ex;

import java.util.Scanner;

public class MethodEx4 {
    public static void main(String[] args) {
        int balance = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
        System.out.println("=================================");

        while (true) {
            System.out.print("선택: ");

            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.print("입금액을 선택하세요: ");
                int depositAmount =  input.nextInt();
                balance= deposit(balance, depositAmount);
            } else if (choice.equals("2")) {
                System.out.print("출금액을 선택하세요: ");
                int withdrawAmount =  input.nextInt();
                balance= withdraw(balance, withdrawAmount);
            } else if (choice.equals("3")) {
                System.out.println("현재 잔액: " + balance);
            } else if (choice.equals("4")) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("올바른 메뉴를 선택해주세요");
            }
        }

    }

    public static int deposit(int balance, int depositAmount) {
        balance += depositAmount;
        System.out.println(depositAmount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        return balance;
    }

    public static int withdraw(int balance, int withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(withdrawAmount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
