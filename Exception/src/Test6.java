public class Test6 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[20]);//发生数组越界异常，该异常没有被捕获，将交给JVM处理
        System.out.println("我是异常代码的后续代码，我被执行了！");
    }
}
