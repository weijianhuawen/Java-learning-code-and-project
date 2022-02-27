public class Test7 {
    public static void main(String[] args) {
        int a = 2;
        int[] arr = new int[10];
        String str = null;
        try {
            System.out.println(8 / a);
            System.out.println(arr[20]);
            System.out.println(str.equals("aaa"));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("捕捉到了除数为0异常！");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界异常！");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个空指针异常！");
        }
    }
}
