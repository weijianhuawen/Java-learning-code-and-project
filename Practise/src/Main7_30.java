import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;



public class Main7_30 {
    /**
     * 有一组日期字符串，大部分格式为"yyyy-MM-dd"。其中一些字符串不符合该格式。
     *
     * 先需要将其转化为用户指定格式字符串toPattern，如"MM dd, yyyy"，即"月 日, 年"。
     *
     * 在转换过程中，如果碰到错误，需要提示：“出错的行. 异常信息。”，全部处理完后，需提示：“总共有几行出错”。
     *
     * 转换完以后，将所有日期从小到大排序。
     *
     * 然后将其按照toPattern模式输出。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Date> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            try {
                Date date = simpleDateFormat.parse(line);
                list.add(date);
            } catch (ParseException e) {
                System.out.println("Line " + i + " error. Unparseable date: \"" + line + "\"");
                cnt++;
            }
        }
        System.out.println("Totally " + cnt + " lines error.");
        Collections.sort(list);
        for (Date x: list) {
            String date = new SimpleDateFormat("MM dd, yyyy").format(x);
            System.out.println(date);
        }
    }
    public static boolean isOdd(int data) {
        return (data & 1) == 0;
    }
    public static int numofHan(String data[]) {
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            String[] strs = data[i].split(",");
            if (strs[3].contains("汉")) cnt++;
        }
        return cnt;
    }


}
