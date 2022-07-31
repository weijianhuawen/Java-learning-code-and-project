public class TestDemo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("又又是一个不起眼的线程！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //收尾工作
                    System.out.println("收尾工作！");
                    break;
                }
            }
        });
        thread.start();

        //main休眠5秒
        Thread.sleep(5000);

        //使用interrupt方法修改线程标志位，使其中断
        thread.interrupt();
    }
}
