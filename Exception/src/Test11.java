import java.util.InputMismatchException;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            System.out.println(10 / a);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入数据类型错误！");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常，除数为0！");
        }
        //关闭资源
    }
}
