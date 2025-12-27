package enumeration.ex1;

public class StringGradeEx1_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        int vip = discountService.discount("VIP", price); // 존재하지 않는 등급
        System.out.println("VIP 등급의 할인 금액: " + vip);

        int diamondd = discountService.discount("DIAMONDD", price); // 오타
        System.out.println("DIAMONDD 등급의 할인 금액: " + diamondd);

        int gold = discountService.discount("gold", price); // 소문자
        System.out.println("gold 등급의 할인 금액: " + gold);
    }
}
