import java.util.Arrays;

public class ReverseArr {
    public static void rever(int[] arr) {
        if (arr == null) {
            return;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("逆序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("逆序后：");
        rever(arr);
        System.out.println(Arrays.toString(arr));
    }
}
