import java.util.Arrays;
import java.util.Scanner;

public class Main3346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] data = new int[7];
        //将数据存入数组，排序，那么最小的一定是A,B， 最大的一定是A+B+C , C=A+B+C - (A+B)
        for (int i = 0; i < 7; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        System.out.println(data[0] + " " + data[1] + " " + (data[6]-data[0]-data[1]));
    }
}
