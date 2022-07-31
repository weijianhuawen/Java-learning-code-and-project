package juc;

import java.util.concurrent.CountDownLatch;

public class Practice {
    public static final int COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "到达终点！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        //等待计数器清零，清零前，线程处于阻塞等待状态，清零后，即全部任务执行完毕
        countDownLatch.await();
        System.out.println("全部到达终点！");
    }
}
