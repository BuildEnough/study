package static2.ex;

public class MathArrayUtils {
    private MathArrayUtils() {
    }

    public static int sum(int[] array) {
        int sumResult = 0;
        for (int i = 0; i < array.length; i++) {
            sumResult += array[i];
        }
        return sumResult;
    }

    public static double average (int[] array) {
        int sumResult = sum(array);
        return (double) sumResult / array.length;
    }

    public static int min (int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max (int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
