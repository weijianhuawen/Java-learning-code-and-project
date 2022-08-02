import java.util.Arrays;
import java.util.Scanner;

public class Main4380 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int k = 0;
        int index1 = 0;
        int index2 = 0;
        int i = index1+1;
        int j = index2+1;

        while (index1 < n && index2 < m) {
            if (arr1[index1] > arr2[index2] && j < m) {
                for (int l = m - 1; l > index2; l--) {
                    int sum = arr2[index2] + arr2[l];
                    if (sum == arr1[index1]) {
                        int tmp = arr2[j];
                        arr2[j] = arr2[l];
                        arr2[l] = tmp;
                    }
                }
                arr2[index2] += arr2[j];
                arr2[j++] = 0;
            } else if (arr1[index1] < arr2[index2] && i < n) {
                for (int l = n - 1; l > index1; l--) {
                    int sum = arr1[index1] + arr1[l];
                    if (sum == arr2[index2]) {
                        int tmp = arr1[i];
                        arr1[i] = arr1[l];
                        arr1[l] = tmp;
                    }
                }
                arr1[index1] += arr1[i];
                arr1[i++] = 0;
            } else {
                k++;
                index1++;
                index2++;
            }
        }
        System.out.println(k);
    }
}
