import java.util.concurrent.ThreadLocalRandom;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("使用Runnable描述任务!");
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        //将Runnable任务传给Thread对象来创建运行线程
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);

        thread.start();
    }
}
