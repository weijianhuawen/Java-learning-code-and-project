import java.util.Arrays;


public class TestBolg {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 8 + i +j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}

/*public class TestBolg {
    public static void arrFunc(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 * (i+1);
        }
    }
    public static void main(String[] args) {
        int[] x = new int[3];
        arrFunc(x);
        System.out.println(Arrays.toString(x));

    }
}*/
