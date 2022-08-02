import java.util.Random;
import java.util.Scanner;

public class Main7_32 {
    /**
     * 尝试使用蒙特卡罗法计算圆周率（π）的值。原理如下：
     *
     * 以原点(0, 0)作为圆心，半径为1画一个圆。该圆的外切正方形，边长为2。
     *
     * 现往该正方形内随机投点，数量足够多的情况下，落入圆内的点与落入整个
     * 外切正方形的点的数量比值大概为：
     * 4∗r
     * 2
     *
     * π∗r
     * 2
     *
     * ​
     *  ，然后就可以得到π的值。
     *
     * 注意
     *
     * 请使用jdk库中的Random对象来生成随机数。
     * 使用Math类中的sqrt与pow函数来计算开根号与平方值。
     * 让点(x,y)投在整个矩形中，x与y的取值范围为(-1≤x<1, -1≤y<1)。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long seed = sc.nextLong();
        int n = sc.nextInt();

        Random random = new Random(seed);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble() * 2 -1;
            double y = random.nextDouble() * 2 -1;
            double flag = Math.pow(x, 2) + Math.pow(y, 2);
            if (flag <= 1) cnt++;
        }
        double pi = 4.0 * cnt / n;
        System.out.println(pi);
    }
}
