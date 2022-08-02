import java.util.Scanner;

public class Main7_8 {
    /**
     * 编写程序，读取用户输入的代表总金额的double值，打印表示该金额所需的最少纸币张数和硬币个数，打印从最大金额开始。纸币的种类有十元、五元、一元，硬币的种类有五角、一角、贰分、壹分。
     * @param args 7-8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double money = sc.nextDouble();

        int ten = (int) (money / 10);
        money = money - ten * 10;
        int five = (int) (money / 5);
        money = money - five * 5;
        int one = (int) money;
        money = money  - one;
        int fiveBin = (int) (money * 2);
        money = money - fiveBin * 0.5;
        int oneBin = (int) (money * 10);
        money = money - oneBin * 0.1;
        int twoFen = (int) (money / 0.02);
        money = money - twoFen * 0.02;
        int oneFen = (int) (money / 0.01);
        money = money - oneFen * 0.01;

        if (ten != 0) System.out.println(ten + " 张十元");
        if (five != 0) System.out.println(five + " 张五元");
        if (one != 0) System.out.println(one + " 张一元");
        if (fiveBin != 0) System.out.println(fiveBin + " 个五角");
        if (oneBin != 0) System.out.println(oneBin + " 个一角");
        if (twoFen != 0) System.out.println(twoFen + " 个贰分");
        if (oneFen != 0) System.out.println(oneFen + " 个一分");
    }
}
