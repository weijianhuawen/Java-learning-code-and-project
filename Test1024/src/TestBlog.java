import java.util.Scanner;
import java.util.Arrays;

public class TestBlog {
    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int sumAdd(int n) {
        if ( n == 1) {
            return n;
        }
        return n + sumAdd(n - 1);
    }
    public static void main14(String[] args) {
        System.out.println(sumAdd(10));
    }
    public static void everyNum(int n) {
        if (n < 10) {
            System.out.print(n + "  ");
            return;
        }
        everyNum(n / 10);
        System.out.print(n % 10 + "  ");
    }
    public static void main13(String[] args) {
        everyNum(1234);
    }
    public static int sum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum(n / 10);
    }
    public static void main12(String[] args) {
        System.out.println(sum(123456));
    }
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main11(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(fib(i));
        }
    }
    public static void move(char m, char n) {
        System.out.println(m + "->" + n);
    }
    public static void hanoi(int num, char a, char b, char c) {
        if (num == 1) {
            move(a, c);
            return;
        }
        hanoi(num - 1, a, c, b);
        move(a, c);
        hanoi(num - 1, b, a, c);
    }
    public static void main10(String[] args) {
        //Hanoi（汉诺）塔问题。古代有一个梵塔，塔内有3个座A,B,C。
        //开始时A座上有64个盘子，盘子大小不等，大的在下，小的在上。
        //有一个先知想把这64个盘子从A座移到C座，但规定每次只允许移动一个盘,
        //且在移动过程中在3个座上都始终保持大盘在下，小盘在上。
        //在移动过程中可以利用B座。你能帮这位先知实现他的想法吗？
        //要求编程序输出移动盘子的步骤。
        int num = 3;
        hanoi(3,'A', 'B', 'C');
    }
    //frog1递归，frog2迭代
    public static int frog1(int  n) {
        if (n <= 2) {
            return n;
        }
        return frog1(n - 1) + frog1(n - 2);
    }
    public static int frog2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int fn = 0;
        while (n - 2 != 0) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            n--;
        }
        return fn;
    }
    public static int frogPlus1(int n) {
        if (n == 1) {
            return n;
        }
        return 2 * frogPlus1(n - 1);
    }
    public static int frogPlus2(int n) {
        if (n == 1) {
            return n;
        }
        int f1 = 1;
        int fn = 0;
        while (n - 1 != 0) {
            fn = 2 * f1;
            f1 = fn;
            n--;
        }
        return fn;
    }
    public static int frogPlus3(int n) {
        return (int)Math.pow(2, n - 1);
    }
    public static void main9(String[] args) {
        //青蛙跳台阶
        for (int i = 1; i < 13; i++) {
            System.out.print(frog1(i) + "  ");//青蛙跳台阶递归结果
        }
        System.out.println();
        for (int i = 1; i < 13; i++) {
            System.out.print(frog2(i) + "  ");//青蛙跳台阶迭代结果
        }
        System.out.println();
        for (int i = 1; i < 13; i++) {
            System.out.print(frogPlus1(i) + "  ");//青蛙跳台阶变式递归结果
        }
        System.out.println();
        for (int i = 1; i < 13; i++) {
            System.out.print(frogPlus2(i) + "  ");//青蛙跳台阶变式迭代结果
        }
        System.out.println();
        for (int i = 1; i < 13; i++) {
            System.out.print(frogPlus3(i) + "  ");//青蛙跳台阶变式结论结果
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b, double c) {
        return a + b + c;
    }
    public static void main8(String[] args) {
        System.out.println(add(22, 33));
        System.out.println(add(3.17, 3.86, 5.25));
    }
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    public static double max(double a, double b) {
        return a > b ? a : b;
    }
    public static double max(double a, int b) {
        return a > b ? a : b;
    }
    public static double max(int a, double b) {
        return a > b ? a : b;
    }
    public static void main7(String[] args) {
        System.out.println(max(3, 9));
        System.out.println(max(3.14, 2.11));
        System.out.println(max(3.14, 4));
        System.out.println(max(2, 3.12));
    }
    public static int max2(int a, int b) {
        return a > b ? a : b;
    }
    public static int max3(int a, int b, int c) {
        int max = max2(a, b);
        max = max2(max, c);
        return max;
    }
    public static void main6(String[] args) {
        System.out.println(max2(11, 2));
        System.out.println(max3(35, 23, 9));
    }
    public static int[] oddEevenArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 == 0) {
                while (left < right) {
                    if (arr[right] % 2 == 1) {
                        int tmp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = tmp;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return arr;
    }
    public static void main5(String[] args) {
        int[] data = {2,1};
        oddEevenArr(data);
        System.out.println(Arrays.toString(data));
    }


    public static void main4(String[] args) {
        //求1！+2！+3！+4！+........+n!的和
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = 1;
            int sum = 0;
            for (int i = 1; i <= n ; i++) {
                ret *= i;
                sum += ret;
            }
            System.out.println(sum);
        }
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = 1;
            for (int i = 2; i <= n; i++) {
                ret *= i;
            }
            System.out.println(n + "! = " + ret);
        }
    }
    public static int onlyNum(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];
        }
        return ret;
    }
    public static void main2(String[] args) {
        //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。异或
        int[] data = {11,21,11,32,48,21,66,32,48,86,66};//86只出现一次
        int only = onlyNum(data);
        System.out.println(only);
    }
    //fib1递归，fib2迭代
    public static int fib1(int  n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        while (n - 1 != 0) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
            n--;
        }
        return fn;
    }
    public static void main1(String[] args) {
        //斐波拉契数列
        for (int i = 0; i < 13; i++) {
            System.out.print(fib1(i) + "  ");//递归结果
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(fib2(i) + "  ");//迭代结果
        }
    }
}
