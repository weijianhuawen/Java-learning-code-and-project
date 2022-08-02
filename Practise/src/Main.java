import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        double b = sc.nextDouble();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int f = sc.nextInt();

        System.out.printf("%d %o %x", a, a, a);
        System.out.println();
        System.out.printf("%6.2f", b);
        System.out.println();
        System.out.printf("%5d%5d%5d", c, d, f);
        System.out.println();
        System.out.printf("%5d%5d%5d", d, f, c);
        System.out.println();
        System.out.printf("%5d%5d%5d", f, c, d);
        System.out.println();
    }
}
