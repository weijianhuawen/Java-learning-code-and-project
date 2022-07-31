public class TestDemo6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("使用Lambda表达式表示匿名内部类来创建匿名任务"));
        thread.start();
    }
}
