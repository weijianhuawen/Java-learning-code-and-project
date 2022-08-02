import java.util.Scanner;

public class Main2249 {
    public static int search(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid  = left + ((right - left) >>> 1);
            if (data[mid] > target) right = mid - 1;
            else if (data[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int cnt = scanner.nextInt();
        int[] arr = new int[len];

        for (int i =0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] find = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            find[i] = scanner.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            int index = search(arr, find[i]);
            if (index >= 0) {
                for (int j = index-1; j  >= 0; j--) {
                    if (j == 0 && arr[j] == arr[index]) index = j;
                    if (arr[j] != arr[index]) index = j + 1;
                }
                System.out.print(index+1 + " ");
            } else {
                System.out.println(-1);
            }
        }
    }
}
