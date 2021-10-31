import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Test {
    public static int sumEveryOne(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumEveryOne(n / 10);
    }

    public static void main19(String[] args) {
        int n = 8921;
        int sum = sumEveryOne(n);
        System.out.println(sum);
    }
    public static int sumAdd(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + sumAdd(n - 1);
        return sum;
    }

    public static void everyNum(int n) {
        if (n < 10) {
            System.out.print(n + "  ");
            return;
        }
        everyNum(n / 10);
        System.out.print(n % 10 + "  ");
    }
    public static void main17(String[] args) {
        //13. 输出一个整数的每一位.
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            everyNum(n);
            System.out.println();
        }
    }
    public static int bin(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
    public static int[] oddEven(int n, int[] oddEven) {
        int flag = 1;
        //前16存奇数位，后16存偶数位
        int i = 0;
        int j = 16;
        while (n != 0) {
            if (flag % 2 == 0) {
                oddEven[j++] = n & 1;
            }
            else {
                oddEven[i++] = n & 1;
            }
            n >>= 1;
            flag++;
        }
        return oddEven;
    }
    public static void main18(String[] args) {
        //12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
        //以最右端为第一位来计算
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] ret = new int[32];
            oddEven(n, ret);
            System.out.println("二进制奇数位：");
            System.out.print("  ");
            for (int i = 15; i >= 0; i--) {
                System.out.print(ret[i] + "   ");
            }
            System.out.println();
            System.out.println("二进制偶数位：");
            for (int i = 31; i >= 16; i--) {
                System.out.print(ret[i] + "   ");
            }
            System.out.println();
            System.out.println("Tips：二进制序列最右端为第1位，从右向左依次增加！");
        }
    }
    public static void main16(String[] args) {
        //11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int cnt = 0;
            int n = sc.nextInt();
            int ret = bin(n);
            System.out.println("数字" + n + "二进制中1的个数为：" + ret + "个！");
        }
    }
    public static void main15(String[] args) {
        //10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
        int cnt = 3;
        Scanner sc = new Scanner(System.in);
        String ans = "weijianhuawen";
        while (cnt != 0) {
            System.out.println("你有" + cnt + "次机会输入密码！请输入密码：");
            String password = sc.nextLine();
            if (password.equals(ans)) {
                System.out.println("密码正确！\n登录成功了！");
                break;
            }
            else {
                cnt--;
                if (cnt != 0) {
                    System.out.println("密码错误！\n你还有" + cnt + "次机会输入密码！");
                }
                else {
                    System.out.println("密码错误！\n输入机会已经用光！无法再次输入密码！");
                }
            }
        }
    }
    public static void main14(String[] args) {
        //14. 完成猜数字游戏
        Random rand = new Random();
        int ans = rand.nextInt(101);
        Scanner sc = new Scanner(System.in);
        int cnt  = 0;
        while (true) {
            System.out.println("请猜一个0-100以内的数字：");
            int guess = sc.nextInt();
            if (guess > ans) {
                System.out.println("猜大了！");
                cnt++;
            }
            else if (guess < ans) {
                System.out.println("猜小了！");
                cnt++;
            }
            else {
                cnt++;
                System.out.println("恭喜你!" + "猜了" + cnt + "次" + "猜对了!");
                break;
            }
        }
    }
    public static void main13(String[] args) {
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一！");
                break;
            case 2:
                System.out.println("星期二！");
                break;
            case 3:
                System.out.println("星期三！");
                break;
            case 4:
                System.out.println("星期四！");
                break;
            case 5:
                System.out.println("星期五！");
                break;
            case 6:
                System.out.println("星期六！");
                break;
            case 7:
                System.out.println("星期日！");
                break;
            default:
                System.out.println("错误！");
                break;
        }

    }
    public static void main12(String[] args) {
        int n = 99;
        if (n == 99) {
            System.out.println(99);
        }else if (n == 98) {
            System.out.println(98);
        }else if (n == 97) {
            System.out.println(97);
        } else {
            System.out.println(88);
        }
    }
    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //比如需要输入多行输入字符串
            String str = sc.nextLine();
            System.out.println(str);
        }
    }
    public static void main10(String[] args) {
        Scanner sc = new Scanner(System.in);//System.in 表示从键盘输入
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();//由于Java的输入做的很粗糙，有一些bug，比如如果先读数字在读字符串，字符串就读不了了，所以建议先读字符串再读数字
        System.out.println(str);
        System.out.println("请输入一个整数：");
        int a = sc.nextInt();//整型输入调用nextInt。如果是double 则调用nextDouble，一行字符串建议使用nextLine，以空格隔开的字符串建议next
        System.out.println(a);
        System.out.println("请输入一个小数：");
        double b = sc.nextDouble();
        System.out.println(b);
    }
    public static void main9(String[] args) {
        //9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
        int n = 999999;
        int start = 0;

        for (int i = start; i <= n; i++) {
            int num = 0;
            int a = i;
            int cnt  = 0;
            int m = i;
            while(m != 0) {
                m /= 10;
                cnt ++;
            }
            while(a != 0) {
                num += Math.pow(a % 10, cnt);
                a /= 10;
            }
            if (num == i) {
                System.out.println(i);
            }
        }
    }
    public static void main8(String[] args) {
        //8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
        int n = 100;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 10 == 9) {
                cnt++;
            }
            if (i / 10 == 9) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void main7(String[] args) {
        //7.计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
        int n = 100;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += 1.0 / i;
            }else {
                sum -= 1.0 / i;
            }
        }
        System.out.println(sum);
    }
    public static void main6(String[] args) {
        //6. 求两个正整数的最大公约数
        int n1 = 6;
        int n2 = 3;
        int a = n1;
        int b = n2;
        int rema = b;
        while (rema != 0) {
            rema = a % b;
            a = b;
            b = rema;
        }
        int divi = a;
        System.out.println(n1 + "与" + n2 + "的最大公约数为：" + divi);
        System.out.println(n1 + "与" + n2 + "的最小公倍数为：" + (n1*n2/divi));
    }
    public static void main5(String[] args) {
        //输出乘法口诀表
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d x %d = %d\t", j, i, i*j);
            }
            System.out.println();
        }
    }
    public static void main4(String[] args) {
        //4. 输出 1000 - 2000 之间所有的闰年
        int cnt = 0;
        int start = 1000;
        int end  = 2000;
        for (int i = start; i <= end; i++) {
            if (i % 100 != 0 && i % 4 == 0 || i % 400 == 0) {
                cnt++;
                System.out.println(i);
            }
        }
        System.out.println("1000-2000闰年有" + cnt + "个");
    }
    public static void main3(String[] args) {
        //3. 打印 1 - 100 之间所有的素数
        int n = 100;
        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            if (isPrime(i)) {
                cnt++;
                System.out.print(i + "  ");
            }
        }
        System.out.println("1-" + n + "素数有" + cnt + "个");
    }
    public static boolean isPrime(int a) {
        //2. 判定一个数字是否是素数
        if (a == 2) {
            return true;
        }
        if (a % 2 == 0 || a <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main2(String[] args) {
        //2. 判定一个数字是否是素数
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            if (a == 2) {
                System.out.println(a + "是素数！");
                continue;
            }
            boolean flag = true;
            if (a % 2 == 0 || a <= 1) {
                System.out.println(a + "不是素数！");
            }else {
                for (int i = 2; i < a - 1; i++) {
                    if (a % i == 0) {
                        System.out.println(a + "不是素数！");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(a + "是素数！");
                }
            }
        }
    }
    public static void main1(String[] args) {
        //1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int age= scan.nextInt();
            if (age <= 18) {
                System.out.println("少年！");
            }else if (age <= 28) {
                System.out.println("青年！");
            }else if (age <= 55){
                System.out.println("中年！");
            }else {
                System.out.println("老年！");
            }
        }
    }
}
