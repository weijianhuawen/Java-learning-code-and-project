package main.wei.jian.hua.wen;

import java.util.Scanner;

public class Main {
    /**
     * 输入一组数，将其中的奇数、偶数分别求和并输出
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if ((tmp & 1) == 1) sum1 += tmp;
            else sum2 += tmp;
        }
        System.out.println("奇数和=" + sum1 + ", 偶数和=" + sum2);
    }
}
