class testBlog1 {
    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static long add(long a, long b) {
        return a + b;
    }
    public static void main1(String[] args) {
        //方法的重载
        System.out.println(Integer.MAX_VALUE);//整型最大值

        System.out.println(add(2, 6));//整型相加
        System.out.println(add(3.14, 2.86));//浮点数相加
        System.out.println(add(2147483648L,2147483649L));//长整型相加
    }
}
class testBlog2 {
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main2(String[] args) {
        //递归，n的阶乘
        System.out.println(factorial(5));
    }
}
class testBlog3 {
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
    public static void main3(String[] args) {
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

class testBlog4 {
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
    public static void main4(String[] args) {
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
}
public class testBlog {
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
    public static void main(String[] args) {
        //Hanoi（汉诺）塔问题。古代有一个梵塔，塔内有3个座A,B,C。
        //开始时A座上有64个盘子，盘子大小不等，大的在下，小的在上。
        //有一个先知想把这64个盘子从A座移到C座，但规定每次只允许移动一个盘,
        //且在移动过程中在3个座上都始终保持大盘在下，小盘在上。
        //在移动过程中可以利用B座。你能帮这位先知实现他的想法吗？
        //要求编程序输出移动盘子的步骤。
        int num = 3;
        hanoi(3,'A', 'B', 'C');
    }
}