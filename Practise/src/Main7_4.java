import java.util.Scanner;

public class Main7_4 {
    //输入一个华氏温度，输出摄氏温度，其转换公式为：C=5(F-32)/9。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double f = sc.nextDouble();
        double c = 5 * (f - 32) / 9;
        System.out.printf("%.2f", c);
    }
}
