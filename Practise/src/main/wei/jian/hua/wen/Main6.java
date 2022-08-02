package main.wei.jian.hua.wen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main6 {
    /**
     * 输入字符串n-x-y，其中n代表数量，x代表姓，y代表名。
     *
     * 然后输入n个人的信息，每一行代表一个人的信息。
     *
     * 每行字符串格式为"姓-名-成绩-编号"，以-作为分隔符。
     *
     * 并将所有姓为x的字符串放入数组列表list1中。 输出list1
     * 进一步的将list1中的中名字为y(忽略大小写)的字符串取出放入list2中。 输出list2
     *
     * 然后对list2的字符串按成绩进行降序排列并输出。
     * @param args f
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strs = str.split("-");
        int n = Integer.valueOf(strs[0]);
        String x = strs[1];
        String y = strs[2];

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] strs1 = input.split("-");
            if (strs1[0].equals(x)) {
                list1.add(input);
                if (strs1[1]. equalsIgnoreCase(y)) {
                    list2.add(input);
                }
            }

        }
        System.out.println(list1);
        System.out.println(list2);
        list2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int val1 = Integer.valueOf(o1.split("-")[2]);
                int val2 = Integer.valueOf(o2.split("-")[2]);

                return val2 - val1;
            }
        });
        System.out.println(list2);
    }
}
