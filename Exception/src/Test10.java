import java.util.InputMismatchException;
import java.util.Scanner;
常，除数为0！");
        }
        sc.close();//关闭资源
        }
        }

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            System.out.println(10 / a);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入数据类型错误！");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异