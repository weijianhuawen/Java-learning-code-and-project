import java.util.Scanner;

public class Main4319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long num = (long)arr[i] * arr[j];
                int cnt = 0;
                for (int l = 1; l <= 100000; l++) {
                    if (num == (long)Math.pow(l, k)) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
