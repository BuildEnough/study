package static2.ex;

import static static2.ex.MathArrayUtils.*;

public class MathArrayUtilsMain {
    public static void main(String[] args) {
        int[] newArray = {1, 2, 3, 4, 5};
        System.out.println("sum = " + sum(newArray));
        System.out.println("average = " + average(newArray));
        System.out.println("min = " + min(newArray));
        System.out.println("max = " + max(newArray));

    }
}
