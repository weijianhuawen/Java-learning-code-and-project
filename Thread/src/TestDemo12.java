public class TestDemo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕！");
        });

        thread.start();
        System.out.println("wait前");
        thread.wait();
        System.out.println("wait后");
    }
}
