class Task{
    public void task(int i) {
        System.out.println("任务" + i + "完成！");
    }
}

public class WiteNotify {
    //锁对象
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                Task task1 = new Task();
                task1.task(1);
                //通知线程2线程1的任务完成
                System.out.println("notify前");
                lock.notify();
                System.out.println("notify后");
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                Task task2 = new Task();
                //等待线程1的任务1执行完毕
                System.out.println("wait前");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task2.task(2);
                System.out.println("wait后");
            }
        });
        thread2.start();
        Thread.sleep(10);
        thread1.start();
    }
}
