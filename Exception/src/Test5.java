public class Test5 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        try {
            System.out.println(arr[20]);
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界异常！");
        }
        System.out.println("我是异常代码的后续代码，我被执行了！");
    }
}
