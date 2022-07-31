public class TestDemo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建任务匿名对象");
            }
        });
        thread.start();
    }
}
