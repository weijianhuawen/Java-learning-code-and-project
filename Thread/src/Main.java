import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int CNT = 50000;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                count.getAndIncrement();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                count.getAndIncrement();
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(count);
    }

}
