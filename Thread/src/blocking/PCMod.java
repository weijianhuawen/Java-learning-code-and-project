package blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PCMod {
    private static final MyBlockingQueue queue = new MyBlockingQueue();
    public static void main(String[] args) {
        //生产者
        Thread producer = new Thread(() -> {
            int num = 0;
            while (true) {
                try {
                    System.out.println("生产了:" + num);
                    queue.put(num++);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        //消费者
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int product = queue.take();
                    System.out.println("消费了:" + product);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();
    }
}


//循环队列
class MyCircularQueue {
    //队列数据
    private int[] elem = new int[100];
    //队头指针
    private int head;
    //队尾指针
    private int tail;
    //队列元素个数
    private int size;


    //出队头元素
    public Integer take() {
        if (size == 0) {
            //队列为空
            return null;
        }
        int ret = elem[head];
        head++;
        //作用等价于 head %= elem.length
        if (head >= elem.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    //入队尾元素
    public void put(int val) {
        if (size == elem.length) {
            //队列满
            return;
        }
        elem[tail++] = val;
        //作用等价于 tail %= elem.length
        if (tail >= elem.length) {
            tail = 0;
        }
        size++;
    }
}

//线程安全的循环队列
class MySafeCircularQueue {
    //队列数据
    private int[] elem = new int[100];
    //队头指针
    private int head;
    //队尾指针
    private int tail;
    //队列元素个数
    private int size;
    //专门的锁对象
    private final Object locker = new Object();

    //出队头元素
    public Integer take() {
        synchronized (locker) {
            if (size == 0) {
                //队列为空
                return null;
            }
            int ret = elem[head];
            head++;
            //作用等价于 head %= elem.length
            if (head >= elem.length) {
                head = 0;
            }
            size--;
            return ret;
        }
    }

    //入队尾元素
    public void put(int val) {
        synchronized (locker) {
            if (size == elem.length) {
                //队列满
                return;
            }
            elem[tail++] = val;
            //作用等价于 tail %= elem.length
            if (tail >= elem.length) {
                tail = 0;
            }
            size++;
        }
    }
}

//基于循环队列实现阻塞队列
class MyBlockingQueue {
    //初始化循环队列
    private int[] elem = new int[3];

    //队头指针
    private int head;
    //队尾指针
    private int tail;
    //元素个数
    private int size;
    //专门的锁对象
    private final Object locker = new Object();


    //队头出元素,如果队列为空则阻塞
    public Integer take() throws InterruptedException {
        //循环队列为空,需要阻塞线程,直到循环队列入元素后才通知线程继续执行该操作
        synchronized (locker) {
            if (size == 0) {
                locker.wait();
            }
            int ret = elem[head++];
            if (head >= elem.length) {
                head = 0;
            }
            size--;
            //循环队列出元素后,队列就不为满了,可以通知线程继续进行入队操作
            locker.notify();
            return ret;
        }
    }
    //队尾入元素,如果队列满了,就阻塞
    public void put(int val) throws InterruptedException {
        //循环队列如果满了,则需要使线程阻塞,直到循环队列出元素后才通知线程继续执行该操作
        synchronized (locker) {
            if (size == elem.length) {
                locker.wait();
            }
            elem[tail++] = val;
            if (tail >= elem.length) {
                tail = 0;
            }
            size++;
            //循环队列入元素后,队列就不为空了,可以通知线程继续进行出队操作
            locker.notify();
        }
    }
}