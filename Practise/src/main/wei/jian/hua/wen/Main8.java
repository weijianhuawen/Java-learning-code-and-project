package main.wei.jian.hua.wen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main8 {
    /**
     * 使用随机数填充ArrayList并输出。
     *
     * 注意：
     *
     * 1.建议使用StringBuilder拼接。
     *
     * 2.使用Arrays.sort排序，Arrays.toString输出数组。
     * @param args f
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int seed = sc.nextInt();
        int down = sc.nextInt();
        int up = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(up) + down);
        }
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int[] arr = new int[10];
        int j = 0;
        for (int i = n - 10; i < n; i++) {
            int tmp = list.get(i);
            System.out.print(tmp + " ");
            stringBuilder.append(tmp);
            arr[j++] = tmp;
            sum += tmp;
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(stringBuilder.toString());
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
