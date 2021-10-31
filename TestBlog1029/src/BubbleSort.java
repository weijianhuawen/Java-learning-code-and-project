import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag  = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,1,8,5,9,4,6,7,3};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
