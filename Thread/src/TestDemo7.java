public class TestDemo7 {
    public static void main(String[] args) {
        //thread 线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread线程执行中！");
                    //为了使效果更加明显 可以使用sleep方法设定线程睡眠时间
                    try {
                        Thread.sleep(1000);//每执行一次循环就睡眠1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        //main 线程
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程执行中！");
            //为了使效果更加明显 可以使用sleep方法设定线程睡眠时间
            try {
                Thread.sleep(1000);//每执行一次循环就睡眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
