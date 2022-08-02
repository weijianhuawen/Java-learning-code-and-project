import java.util.Scanner;

public class Main7_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int oddNum = 0;
        int evenNum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && (i & 1) == 1) oddNum++;
            if (i % 3 == 0 && (i & 1) == 0) evenNum++;
        }
        System.out.println(oddNum + "," + evenNum);
    }
}
