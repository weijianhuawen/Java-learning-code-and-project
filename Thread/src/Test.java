import javax.swing.plaf.synth.SynthEditorPaneUI;

public class Test {
    private static final long COUNT = 20_0000_0000L;
    //两个线程
    public static void many() throws InterruptedException {
        //获取开始执行时间戳
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a++;
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < COUNT; i++) {
                b++;
            }
        });
        thread2.start();

        //等待两个线程结束 再获取结束时的时间戳
        thread1.join();
        thread2.join();
        long end = System.currentTimeMillis();

        //执行时间，单位为毫秒
        System.out.println("多线程执行时间：" + (end - start) + "ms");
    }
    //单线程
    public static void single() {
        //记录开始执行的时间戳
        long start = System.currentTimeMillis();

        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b++;
        }
        //获取执行结束时的时间戳
        long end = System.currentTimeMillis();
        System.out.println("单线程执行时间：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        //多线程
        many();
        //单线程
        single();
    }
}
