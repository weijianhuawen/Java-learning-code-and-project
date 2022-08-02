import java.util.Scanner;

public class Main7_33 {
    /**
     * 根据输入的正整数y所代表的年份，计算输出该年份是否为闰年 闰年的判断标准：
     *
     * 能够被4整除且不能被100整除的年份
     *
     * 或者能够被400整除的年份
     */
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (isLeap(n)) System.out.println("yes");
        else System.out.println("no");
    }
}
