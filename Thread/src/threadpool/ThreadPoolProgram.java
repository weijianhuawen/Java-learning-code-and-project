package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadPoolProgram {
    private static int NUMS = 1;
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);
        
        for (int i = 0; i < 20; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + NUMS + "个任务！" );
                }
            });
            Thread.sleep(200);
            NUMS++;
        }
    }
}

class MyThreadPool {
    //1.需要一个类来描述具体的任务，直接使用Runnable即可
    //2.有了任务，我们需要将多个任务组织起来，可以使用阻塞队列
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    //3.组织好任务，就可以分配线程池中的线程来执行任务了，所以我们需要描述线程，专门来执行任务
    static class Worker extends Thread {
       //获取任务队列
        private final BlockingQueue<Runnable> queue;
        //构造线程时需要将任务队列初始化
        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }
        //重写线程中的run方法，用来执行阻塞队列中的任务
        @Override
        public void run() {
           while (true) {
               try {
                   //获取任务
                   Runnable runnable = queue.take();
                   //执行任务
                   runnable.run();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
    // 4.线程池中肯定存在不止一个线程，所以我们需要对线程进行组织，这里我们可以使用顺序表，使用链表也可以
    private final List<Worker> workers = new ArrayList<>();

    //根据构造方法指定的线程数将线程存入workers中
    public MyThreadPool(int threadNums) {
        for (int i = 0; i < threadNums; i++) {
            Worker worker = new Worker(this.queue);
            worker.start();
            this.workers.add(worker);
        }
    }
    // 5.创建一个方法，用来将任务存放到线程池中
    public void submit(Runnable runnable) {
        try {
            this.queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}