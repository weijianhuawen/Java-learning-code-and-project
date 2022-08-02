import java.util.*;


public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        int flag = data[1] - data[0];
        if (flag > 0) flag = 1;
        else if (flag == 0) flag = 0;
        else flag = -1;

        int tmp = 0;
        int ans = 1;

        for (int i = 0; i < n - 1; i++) {
            if (data[i+1] - data[i] < 0) tmp = -1;
            else if (data[i+1] - data[i] == 0) tmp = 0;
            else tmp= 1;

            if (tmp != 0 && flag == 0) flag = tmp;

            if (tmp != flag && tmp != 0) {
                ans++;
                if (i + 2 < n) {
                    flag = data[i+2] - data[i+1];
                    if (flag > 0) flag = 1;
                    else if (flag < 0) flag = -1;
                }
            }
        }
        System.out.println(ans);
    }
}