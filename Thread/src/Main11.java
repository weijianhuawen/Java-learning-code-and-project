import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Counter {
    private int count;
    synchronized public void increase() {
        ++this.count;
    }
    public int getCount() {
        return this.count;
    }
}

public class Main11 {
    private static final int CNT = 50000;
    private static final Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                counter.increase();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < CNT; j++) {
                counter.increase();
            }
        });

        thread1.start();
        thread2.start();
        thread1.notify();
        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }
}
