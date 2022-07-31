import javax.sound.sampled.FloatControl;
import java.util.Scanner;

public class Main12 {
    private static int isQuit;
    //锁对象
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
                synchronized (lock) {
                    while (isQuit == 0) {

                    }
                    System.out.println("线程thread执行完毕!");
                }
        });
        thread.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入isQuit的值，不为0线程thread停止执行!");
        isQuit = sc.nextInt();
        System.out.println("main线程执行完毕!");
    }
}
