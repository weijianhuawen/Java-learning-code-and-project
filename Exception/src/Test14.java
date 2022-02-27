public class Test14 {
    public static int divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("除0异常！");
        }
        return a / b;
    }
    public static void main(String[] args) {
        try {
            System.out.println(divide(12, 0));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
