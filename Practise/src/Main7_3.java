import java.util.Scanner;

public class Main7_3 {
    //给出三个整数，请你设计一个程序，求出这三个数的和、乘积和平均数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        sc.close();
        int sum = a + b + c;
        System.out.print(sum + " ");
        System.out.print(a * b * c + " ");
        System.out.printf("%.2f", 1.0 * sum / 3);

    }
}
