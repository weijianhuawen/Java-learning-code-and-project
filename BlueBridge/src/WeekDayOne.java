import java.util.Scanner;

public class WeekDayOne {
    /**
     * 整个 2020 世纪（1901 年 1 月 1 日至 2000 年 12 月 31 日之间），一共有多少个星期一？(不要告诉我你不知道今天是星期几)
     *
     */
    public static boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int starty = scan.nextInt();
        int endy = scan.nextInt();

        long days = 0;
        for (int i = starty; i <= endy; i++) {
            if (isLeap(i)) days += 366;
            else days += 365;
        }
        System.out.println(days / 7);
        scan.close();
    }
}
