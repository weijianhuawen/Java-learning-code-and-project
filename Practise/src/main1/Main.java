package main1;

import java.util.Scanner;

public class Main {
    /**
     * 输入一个整数，然后输入一个浮点数（带小数点的数）。
     * 对两个数求和，并输出。然后对和进行开根号并输出。
     * 再将输出后的值转化为字符串（可使用String.valueOf()函数），截取前6个字符（包含小数点）。
     * @param args bb
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        double b = sc.nextDouble();

        double c = b + a;
        System.out.println(c);
        double d = Math.sqrt(c);
        System.out.println(d);
        String str = String.valueOf(d);
        System.out.println(str.substring(0, 6));
    }
}
