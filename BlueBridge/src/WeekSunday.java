import java.util.Scanner;

public class WeekSunday {
    /**
     *  1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
     */
    public static boolean isLeap(long year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
        return false;
    }
    public static void main(String[] args) {
        long week = 5;
        for (long i = 2000; true ; i++) {
            if (isLeap(i)) week += 366;
            else week += 365;
            if (i % 100 == 99 && week % 7 == 0) {
                System.out.println(i);
                break;
            }
            week %= 7;
        }
    }
}
