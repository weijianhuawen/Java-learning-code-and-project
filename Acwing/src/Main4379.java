import java.util.Scanner;

public class Main4379 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (b == d && a == c) {
            System.out.println(b);
            return;
        }

        int i = 0;
        int j = 0;
        while (true) {
            long ret1 = b + a * i;
            long ret2 = d + c * j;
            if (ret1 == ret2) {
                System.out.println(ret1);
                return;
            } else if (ret1 > ret2) {
                j++;
            } else {
                i++;
            }
            if (ret1 > 1000000 || ret2 > 1000000) {
                System.out.println(-1);
                return;
            }
        }
     }
}
