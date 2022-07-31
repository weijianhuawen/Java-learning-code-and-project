public class TestDemo8 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!isQuit) {
                //每隔1秒打印一句
                System.out.println("一个不起眼的线程！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        //main线程阻塞5秒 按理会打印5句话
        Thread.sleep(5000);
        isQuit = true;
    }
}
