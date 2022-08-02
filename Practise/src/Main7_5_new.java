import java.util.Scanner;

public class Main7_5_new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();

        double ans = 0;
        if (x < 5) {
            ans = x - 3;
        } else if (x < 10) {
            double ret = 2 * (x-5);
            ans = Math.sqrt(ret);
        } else {
            ans = 4 * x - 9;
        }
        System.out.printf("%.4f", ans);
    }
}