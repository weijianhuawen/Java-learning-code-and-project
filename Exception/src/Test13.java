public class Test13 {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除0异常！");
        }
        return a / b;
    }
    public static void main(String[] args) {
        System.out.println(divide(12, 0));
    }
}
