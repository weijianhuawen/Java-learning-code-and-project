

public class TestDemo4 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程匿名对象");
            }
        };
        thread.start();
    }
}
