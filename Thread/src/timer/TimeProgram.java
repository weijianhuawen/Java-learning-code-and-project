package timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;

public class TimeProgram {
    public static void main(String[] args) throws InterruptedException {
        MyTimer timer = new MyTimer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行延后2s执行的任务！");
            }
        }, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行延后5s执行的任务！");
            }
        }, 5000);

        //每秒输出一个mian
        for (int i = 0; i < 5; i++) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}


//我的任务
class MyTask implements Comparable<MyTask> {
    //接收具体任务
    private Runnable runnable;
    //执行时的时间戳
    private long time;

    //构造方法
    public MyTask(Runnable runnable, int delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    //执行任务
    public void run() {
        this.runnable.run();
    }
    //获取执行时间
    public long getTime() {
        return this.time;
    }

    //实现comparable接口,方便创建优先级阻塞队列
    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time - o.time);
    }
}
//我的定时类 用来管理任务
class MyTimer {
    //专门对锁对象
    private final Object locker = new Object();
    //每次执行任务时，需要优先执行时间在前的任务，即每次执行任务要选择时间戳最小的任务，在多线程情况中优先级阻塞队列是最佳选择
    private static final PriorityBlockingQueue<MyTask> priorityBlockingQueue = new PriorityBlockingQueue<>();

    //安排任务
    public void schedule(Runnable runnable, int delay) {
        //将任务放入小根堆中
        MyTask task = new MyTask(runnable, delay);
        priorityBlockingQueue.put(task);
        //每次当新任务加载到阻塞队列时，需要中途唤醒线程，因为新进来的任务可能是最早需要执行的
        synchronized (locker) {
            locker.notify();
        }
    }
    public MyTimer() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    //加载任务，确定执行时机
                    MyTask myTask = priorityBlockingQueue.take();
                    long curTime = System.currentTimeMillis();
                    //时间未到，将任务放回
                    if (curTime < myTask.getTime()) {
                        synchronized (locker) {
                            priorityBlockingQueue.put(myTask);
                            //放回任务后，不能立即就再次取该任务加载，需要设置一个再次加载的等待时间,建议使用wait带参数的方法
                            //因为wait方法可以使用notify进行中途唤醒，而sleep不能中途唤醒
                            int delay = (int)(myTask.getTime() - curTime);
                            locker.wait(delay);
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "线程收到任务，正在执行中！");
                        myTask.run();
                        System.out.println(Thread.currentThread().getName() + "线程执行任务完毕，正在等待新任务！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //不要忘了启动线程
        thread.start();
    }
}