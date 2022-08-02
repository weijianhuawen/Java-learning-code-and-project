import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = {0, 4, 6, 9, 10, 13};
        int[] arr2 = {8, 11};
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
            return;
        }
        int ans = 0;
        while (n > 0) {
            int m = n % 16;
            for (int i = 0; i < arr1.length; i++) {
                if (m == arr1[i]) ans++;
            }
            for (int i = 0; i < arr2.length; i++) {
                if (m == arr2[i]) ans += 2;
            }

            n /= 16;
        }
        System.out.println(ans);
    }
}
