import java.util.Arrays;
import java.util.Scanner;

public class Main4317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (data[i] > 0 && data[i+1] - data[i] > 0) ans++;
        }
        System.out.println(ans);
    }
}
