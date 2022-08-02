package main.wei.jian.hua.wen;

import java.util.Scanner;

public class Main3 {
    /**
     * 输入密码x与次数n。然后在若干行字符串中(以end为结尾)寻找包含指定密码（x）的字符串的。
     * 一旦找到就输出该字符串所在行数及该行字符串 。 最后输出包含密码x的字符串行数。
     * 在寻找过程中，如果找到n次包含密码x的字符串则直接跳出循环，否则一直查找直到碰到end为止。
     * @param args gg
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "end";
        String ans = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int cnt = 0;
        int line = 1;
        while (!str.equals(input) && cnt < n) {
            if (input.contains(ans)) {
                System.out.print(line + " ");
                System.out.println(input);
                ++cnt;
            }
            ++line;
            input = sc.nextLine();
        }
        System.out.println(cnt);
    }
}
