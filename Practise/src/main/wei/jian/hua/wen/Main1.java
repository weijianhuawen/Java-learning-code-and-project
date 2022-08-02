package main.wei.jian.hua.wen;

import java.util.Scanner;

public class Main1 {
    /**
     * 输入一组字符串，直到碰到end为之。将其中字符串长度是3的倍数的字符串使用空格拼接起来，并输出
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "end";
        String input = sc.next();
        StringBuilder stringBuilder = new StringBuilder();
        while (!str.equals(input)) {
            if (input.length() % 3 == 0) {
                stringBuilder.append(input);
                stringBuilder.append(" ");
            }
            input = sc.next();
        }
        System.out.println(stringBuilder.toString());
    }
}
