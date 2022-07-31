package juc;

import java.util.concurrent.*;

class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 100 * (1 + 100) / 2;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();

        //获取执行结果
        System.out.println(task.get());
    }
}
class Main2 {
    public static void main(String[] args) throws InterruptedException {
        //构造方法中的permits参数表示可用资源的个数
        Semaphore semaphore = new Semaphore(4);
        //每次使用一个可用资源，信号量就会减少1
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        //此时可用资源为0，线程进入阻塞，需要使用release方法释放资源，线程才能继续执行
        semaphore.release();
        System.out.println("释放成功");
        semaphore.acquire();
        System.out.println("申请成功");
    }
}
public class Main {
    public static final int COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "任务执行完毕！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        //等待计数器清零，清零前，线程处于阻塞等待状态，清零后，即全部任务执行完毕
        countDownLatch.await();
        System.out.println("任务全部完成！");
    }
}
