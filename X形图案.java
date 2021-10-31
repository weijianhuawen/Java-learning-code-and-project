import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //1.打印一个v字型图案 行数为(n+1) / 2
            for (int i = 0; i < (n + 1) / 2; i++) {
                for (int j = 0; j < n - i; j++) {
                    if (j == i || j == n - 1 - i) {
                        System.out.print('*');
                    }
                    else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
            //2.在v字型下补全使之成x字型，行数为n/2 - 1
            for (int i = n / 2 - 1; i >= 0; i--) {
                for (int j = 0; j < n - i; j++) {
                    if (j == i || j == n - 1 - i) {
                        System.out.print('*');
                    }
                    else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }
}