import java.util.Scanner;

public class Main1459 {
    public static void main(String[] args) {
        int[][] cnt = new int[21][21];
        int[] cattle = new int[21];

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        //行表是优势牛 列表示劣势牛
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                cattle[j] = sc.nextInt();
            }
            for (int j = 1; j < n; j++) {
                for (int l = j + 1; l <= n; l++) {
                    cnt[cattle[j]][cattle[l]]++;
                }
            }
        }
        //一共比赛k轮，一对一致牛的优势牛一定每轮都剩余劣势牛，即二维数组中值为k的牛满足条件
        int ans = 0;
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (cnt[i][j] == k) ans++;
            }
        }

        System.out.println(ans);
    }
}
