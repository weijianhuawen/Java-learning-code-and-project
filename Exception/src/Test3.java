public class Test3 {
    public static void main(String[] args) {
        int a = 0;
        try {
            System.out.println(8 / a);
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("捕捉到了除数为0异常！");
        }
        int[] arr = new int[10];
        try {
            System.out.println(arr[20]);
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界异常！");
        }
        String str = null;
        try {
            System.out.println(str.equals("aaa"));
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个空指针异常！");
        }
    }
}
