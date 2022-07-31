class MyThread extends Thread{
    //重写run方法
    @Override
    public void run() {
        System.out.println("你好!线程!");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        //创建MyThread线程对象，但是线程没有创建
        Thread thread = new MyThread();
        //线程创建并运行
        thread.start();
    }
}

