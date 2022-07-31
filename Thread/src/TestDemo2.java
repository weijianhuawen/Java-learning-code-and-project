import java.util.concurrent.TransferQueue;

class Thread1 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("线程1!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("线程2!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread3 extends Thread{

}
class Thread4 extends Thread{

}

public class TestDemo2 {
    public static void main(String[] args) {
        //1.线程1
        Thread thread1 = new Thread1();
        thread1.start();

        //2.main线程
        while (true) {
            System.out.println("线程main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
