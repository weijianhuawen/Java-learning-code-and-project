public class Main13 {
    private static final Object lockera = new Object();
    private static final Object lockerb = new Object();
    private static final Object lockerc = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockerb) {
                    System.out.println("a");
                    lockerb.notify();
                }
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockerb) {
                    try {
                        lockerb.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("b");
                }
                synchronized (lockerc) {
                    lockerc.notify();
                }
            }
        }, "b");
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockerc) {
                    try {
                        lockerc.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("c");
                }
            }
        }, "c");
        c.start();
        b.start();
        a.start();
    }
}
