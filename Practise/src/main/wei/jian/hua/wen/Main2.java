package main.wei.jian.hua.wen;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    /**
     * 输入一组半径值（均为整数）存入数组。
     * 然后对其排序后输出、再逆序输出，并计算平均半径与总面积。
     * @param args f
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        double sumArea = 0;
        int sumR = 0;
        System.out.println(Arrays.toString(data));
        System.out.println();
        for (int i = data.length - 1; i >= 0 ; i--) {
            sumArea += Math.PI * data[i] * data[i];
            sumR += data[i];
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("平均半径=" + (1.0 * sumR / n));
        System.out.printf("总面积=%.6f", sumArea);
    }
}
